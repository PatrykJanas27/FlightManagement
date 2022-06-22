package com.example.FlightManagement.GetCargoData;

import com.example.FlightManagement.Repository.CargoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class CargoService {
    private final CargoRepository cargoRepository;
    private final CargoDtoMapper cargoDtoMapper;

    Optional<CargoDto> getCargoById(Long id) {
        return cargoRepository.findById(id)
                .map(cargoDtoMapper::map);
    }
}
