package com.example.FlightManagement.GetBaggageData;

import com.example.FlightManagement.Repository.BaggageRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
class BaggageService {
    private final BaggageRepository baggageRepository;
    private final BaggageDtoMapper baggageDtoMapper;

    Optional<BaggageDto> getBaggageById(Long id) {
        return baggageRepository.findById(id)
                .map(baggageDtoMapper::map);
    }
}
