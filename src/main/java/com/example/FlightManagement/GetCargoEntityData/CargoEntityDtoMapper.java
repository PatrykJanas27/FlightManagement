package com.example.FlightManagement.GetCargoEntityData;

import com.example.FlightManagement.Entities.CargoEntity;
import org.springframework.stereotype.Service;

@Service
public class CargoEntityDtoMapper {
    CargoEntityDto map(CargoEntity cargoEntity) {
        CargoEntityDto dto = new CargoEntityDto();
        dto.setFlightId(cargoEntity.getFlightId());
        dto.setBaggage(cargoEntity.getBaggage());
        dto.setCargo(cargoEntity.getCargo());
        return dto;
    }
}
