package com.example.FlightManagement.GetCargoData;

import com.example.FlightManagement.Entities.Cargo;
import org.springframework.stereotype.Service;

@Service
public class CargoDtoMapper {
    CargoDto map(Cargo cargo) {
        CargoDto getCargoDto = new CargoDto();
        getCargoDto.setId(cargo.getId());
        getCargoDto.setWeight(cargo.getWeight());
        getCargoDto.setWeightUnit(cargo.getWeightUnit());
        getCargoDto.setPieces(cargo.getPieces());
        return getCargoDto;
    }

}
