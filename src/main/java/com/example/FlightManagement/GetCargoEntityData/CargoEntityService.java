package com.example.FlightManagement.GetCargoEntityData;

import com.example.FlightManagement.Repository.CargoEntityRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class CargoEntityService {
    private final CargoEntityDtoMapper cargoEntityDtoMapper;
    private final CargoEntityRepository cargoEntityRepository;

    Optional<CargoEntityDto> getCargoEntityByFlightId(Long flightId) {
        return cargoEntityRepository.findById(flightId)
                .map(cargoEntityDtoMapper::map);
    }
}
