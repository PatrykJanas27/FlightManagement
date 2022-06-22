package com.example.FlightManagement.GetBaggageData;

import com.example.FlightManagement.Entities.Baggage;
import org.springframework.stereotype.Service;

@Service
class BaggageDtoMapper {
    BaggageDto map(Baggage baggage) {
        BaggageDto dto = new BaggageDto();
        dto.setId(baggage.getId());
        dto.setWeight(baggage.getWeight());
        dto.setWeightUnit(baggage.getWeightUnit());
        dto.setPieces(baggage.getPieces());
        return dto;
    }
}
