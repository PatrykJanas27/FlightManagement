package com.example.FlightManagement.GetFlightEntityData;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
public class FlightEntityController {
    private final FlightEntityService flightEntityService;

    @GetMapping("/getFlightEntity")
    ResponseEntity<FlightEntityDto> getFlightEntityDtoByFlightNumberAndDepartureDate(@RequestParam Integer flightNumber, @RequestParam String departureDate) {
        return flightEntityService.getFlightEntityDtoByFlightNumberAndDepartureDate(flightNumber, departureDate)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getFlightEntity/sumOfCargoWeight")
    @ResponseBody
    Double getSumOfCargoWeightForRequestedFlightNumberAndDepartureDate(@RequestParam Integer flightNumber, @RequestParam String departureDate) {
        return flightEntityService.getSumOfCargoWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
    }

    @GetMapping("/getFlightEntity/sumOfBaggageWeight")
    @ResponseBody
    Double getSumOfBaggageWeightForRequestedFlightNumberAndDepartureDate(@RequestParam Integer flightNumber, @RequestParam String departureDate) {
        return flightEntityService.getSumOfBaggageWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
    }

    @GetMapping("/getFlightEntity/totalWeight")
    @ResponseBody
    Double getTotalWeightForRequestedFlightNumberAndDepartureDate(@RequestParam Integer flightNumber, @RequestParam String departureDate) {
        return flightEntityService.getTotalWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
    }

    @GetMapping("/getFlightEntity/data")
    @ResponseBody
    String getData(@RequestParam Integer flightNumber, @RequestParam String departureDate) {
        double cargoWeight = flightEntityService.getSumOfCargoWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
        double baggageWeight = flightEntityService.getSumOfBaggageWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
        double totalWeight = flightEntityService.getTotalWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
        return "cargoWeight: " + cargoWeight + "\nbaggageWeight: " + baggageWeight + "\ntotalWeight: " + totalWeight;
    }

    @GetMapping("/getFlightEntity/NumberOfFlightsDepartingFromAirport")
    @ResponseBody
    Integer getNumberOfFlightsDepartingFromAirport(@RequestParam String departureAirportIATACode, @RequestParam String departureDate) {
        return flightEntityService.NumberOfFlightsDepartingFromAirport(departureAirportIATACode, departureDate);
    }

    @GetMapping("/getFlightEntity/NumberOfFlightsArrivingToAirport")
    @ResponseBody
    Integer getNumberOfFlightsArrivingToAirport(@RequestParam String arrivalAirportIATACode, @RequestParam String departureDate) {
        return flightEntityService.NumberOfFlightsArrivingToAirport(arrivalAirportIATACode, departureDate);
    }

    @GetMapping("/getFlightEntity/TotalNumberOfBaggageArrivingToAirport")
    @ResponseBody
    Integer getTotalNumberOfBaggageArrivingToAirport(@RequestParam String arrivalAirportIATACode, @RequestParam String departureDate) {
        return flightEntityService.TotalNumberOfBaggageArrivingToAirport(arrivalAirportIATACode, departureDate);
    }

    @GetMapping("/getFlightEntity/TotalNumberOfBaggageDepartingFromAirport")
    @ResponseBody
    Integer getTotalNumberOfBaggageDepartingFromAirport(@RequestParam String departureAirportIATACode, @RequestParam String departureDate) {
        return flightEntityService.TotalNumberOfBaggageDepartingFromAirport(departureAirportIATACode, departureDate);
    }

    @PutMapping("/replaceFlightEntityByFlightId/{id}")
    ResponseEntity<?> replaceFlightEntityByFlightId(@PathVariable Long id, @RequestBody FlightEntityDto flightEntityDto){
        return flightEntityService.replaceFlightEntityByFlightId(id,flightEntityDto)
                .map(f->ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }//if success it returns code 204; if object not existed it returns code 404

    @DeleteMapping("/deleteFlightById/{id}")
    ResponseEntity<?> deleteFlightById(@PathVariable Long id) {
        flightEntityService.deleteFlightByFlightId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/flightEntity/{flightId}")
    ResponseEntity<FlightEntityDto> getFlightByFlightId(@PathVariable Long flightId) {
        return flightEntityService.getFlightEntityByFlightId(flightId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
