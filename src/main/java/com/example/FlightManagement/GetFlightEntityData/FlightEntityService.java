package com.example.FlightManagement.GetFlightEntityData;

import com.example.FlightManagement.Entities.Baggage;
import com.example.FlightManagement.Entities.Cargo;
import com.example.FlightManagement.Entities.CargoEntity;
import com.example.FlightManagement.Entities.FlightEntity;
import com.example.FlightManagement.Repository.FlightEntityRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class FlightEntityService {
    private final FlightEntityDtoMapper flightEntityDtoMapper;
    private final FlightEntityRepository flightEntityRepository;

    Optional<FlightEntityDto> getFlightEntityDtoByFlightNumberAndDepartureDate(Integer flightNumber, String departure) {
        return Optional.of(flightEntityDtoMapper
                .map(flightEntityRepository.findByFlightNumberAndDepartureDate(flightNumber, departure)));
    }

    double getTotalWeightForRequestedFlightNumberAndDepartureDate(Integer flightNumber, String departureDate) {
        double sumOfCargoWeight = getSumOfCargoWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);
        double sumOfBaggageWeight = getSumOfBaggageWeightForRequestedFlightNumberAndDepartureDate(flightNumber, departureDate);

        return sumOfCargoWeight + sumOfBaggageWeight;
    }

    double getSumOfCargoWeightForRequestedFlightNumberAndDepartureDate(Integer flightNumber, String departureDate) {
        List<Cargo> flightEntities =
                flightEntityRepository
                        .findByFlightNumberAndDepartureDate(flightNumber, departureDate)
                        .getCargoEntity()
                        .getCargo();

        double kg = getSumOfCargo(flightEntities, "kg");
        double lb = getSumOfCargo(flightEntities, "lb");
        return kg + lb * 0.45;
    }

    double getSumOfBaggageWeightForRequestedFlightNumberAndDepartureDate(Integer flightNumber, String departureDate) {
        List<Baggage> flightEntities =
                flightEntityRepository
                        .findByFlightNumberAndDepartureDate(flightNumber, departureDate)
                        .getCargoEntity()
                        .getBaggage();

        double kg = getSumOfBaggage(flightEntities, "kg");
        double lb = getSumOfBaggage(flightEntities, "lb");

        return kg + lb * 0.45;
    }

    private int getSumOfCargo(List<Cargo> flightEntities, String unit) {
        return flightEntities.stream()
                .filter(cargo -> Objects.equals(cargo.getWeightUnit(), unit))
                .map(Cargo::getWeight)
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int getSumOfBaggage(List<Baggage> flightEntities, String unit) {
        return flightEntities.stream()
                .filter(cargo -> Objects.equals(cargo.getWeightUnit(), unit))
                .map(Baggage::getWeight)
                .mapToInt(Integer::intValue)
                .sum();
    }

    Integer NumberOfFlightsDepartingFromAirport(String departureAirportIATACode, String departureDate) {
        List<FlightEntity> flightEntities = flightEntityRepository
                .findAllByDepartureAirportIATACodeAndDepartureDate(departureAirportIATACode, departureDate);
        return flightEntities.size();
    }

    Integer NumberOfFlightsArrivingToAirport(String arrivalAirportIATACode, String departureDate) {
        List<FlightEntity> flightEntities = flightEntityRepository
                .findAllByArrivalAirportIATACodeAndDepartureDate(arrivalAirportIATACode, departureDate);
        return flightEntities.size();
    }

    Integer TotalNumberOfBaggageArrivingToAirport(String arrivalAirportIATACode, String departureDate) {
        return flightEntityRepository
                .findAllByArrivalAirportIATACodeAndDepartureDate(arrivalAirportIATACode, departureDate)
                .stream()
                .map(FlightEntity::getCargoEntity)
                .peek(System.out::println)
                .map(CargoEntity::getBaggage)
                .map(listOfBaggages -> listOfBaggages
                        .stream()
                        .map(Baggage::getPieces)
                        .mapToInt(Integer::intValue)
                        .sum()
                ).mapToInt(Integer::intValue).sum();
    }

    Integer TotalNumberOfBaggageDepartingFromAirport(String departureAirportIATACode, String departureDate) {
        return flightEntityRepository
                .findAllByDepartureAirportIATACodeAndDepartureDate(departureAirportIATACode, departureDate)
                .stream()
                .map(FlightEntity::getCargoEntity)
                .peek(System.out::println)
                .map(CargoEntity::getBaggage)
                .map(listOfBaggages -> listOfBaggages
                        .stream()
                        .map(Baggage::getPieces)
                        .mapToInt(Integer::intValue)
                        .sum()
                ).mapToInt(Integer::intValue).sum();
    }

    Optional<FlightEntityDto> getFlightEntityByFlightId(Long flightId) {
        return flightEntityRepository.findById(flightId)
                .map(flightEntityDtoMapper::map);
    }

    void deleteFlightByFlightId(Long id) {
        flightEntityRepository.deleteById(id);
    }

    Optional<FlightEntityDto> replaceFlightEntityByFlightId(Long flightId, FlightEntityDto flightEntityDto) {
        if(!flightEntityRepository.existsById(flightId)){
            return Optional.empty();
        }
        flightEntityDto.setFlightId(flightId);
        FlightEntity flightEntityToUpdate = flightEntityDtoMapper.map(flightEntityDto);
        FlightEntity updatedFlightEntity = flightEntityRepository.save(flightEntityToUpdate);
        return Optional.of(flightEntityDtoMapper.map(updatedFlightEntity));
    }
}
