package com.example.FlightManagement.GetCargoEntityData;

import com.example.FlightManagement.Entities.Baggage;
import com.example.FlightManagement.Entities.Cargo;
import com.example.FlightManagement.Entities.FlightEntity;
import lombok.Data;

import java.util.List;

@Data
class CargoEntityDto {
    private Long flightId;
    private FlightEntity flightEntity;
    private List<Baggage> baggage;
    private List<Cargo> cargo;
}
