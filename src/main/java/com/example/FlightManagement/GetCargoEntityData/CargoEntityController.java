package com.example.FlightManagement.GetCargoEntityData;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class CargoEntityController {
    private final CargoEntityService cargoEntityService;

    @GetMapping("/cargosEntity/{flightId}")
    ResponseEntity<CargoEntityDto> getCargoByFlightId(@PathVariable Long flightId) {
        return cargoEntityService.getCargoEntityByFlightId(flightId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
