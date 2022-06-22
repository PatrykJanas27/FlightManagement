package com.example.FlightManagement.GetCargoData;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class CargoController {
    private final CargoService cargoService;

    @GetMapping("/cargos/{id}")
    ResponseEntity<CargoDto> getCargoById(@PathVariable Long id) {
        return cargoService.getCargoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
