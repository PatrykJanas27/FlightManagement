package com.example.FlightManagement.FillData;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FillDataController {
    private final FillDataService fillDataService;

    @PostMapping("/add/Cargo")
    private void addCargo(@RequestBody List<CargoEntityDto> dto) {
        fillDataService.addCargos(dto);
        fillDataService.addToFlightEntityCargoEntity(dto);
    }

    @PostMapping("/add/Flight")
    private void addFlightEntity(@RequestBody List<FlightEntityDto> dto) {
        fillDataService.addFlights(dto);
    }

}
