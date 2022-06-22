package com.example.FlightManagement.GetBaggageData;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
public class BaggageController {
    private final BaggageService getBaggageService;

    @GetMapping("/baggages/{id}")
    ResponseEntity<BaggageDto> getBaggageById(@PathVariable Long id) {
        return getBaggageService.getBaggageById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
