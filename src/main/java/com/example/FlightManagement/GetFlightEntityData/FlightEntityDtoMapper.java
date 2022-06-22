package com.example.FlightManagement.GetFlightEntityData;

import com.example.FlightManagement.Entities.FlightEntity;
import org.springframework.stereotype.Service;

@Service
public class FlightEntityDtoMapper {
    FlightEntityDto map(FlightEntity flightEntity) {
        FlightEntityDto dto = new FlightEntityDto();
        dto.setFlightId(flightEntity.getFlightId());
        dto.setFlightNumber(flightEntity.getFlightNumber());
        dto.setCargoEntity(flightEntity.getCargoEntity());
        dto.setDepartureAirportIATACode(flightEntity.getDepartureAirportIATACode());
        dto.setArrivalAirportIATACode(flightEntity.getArrivalAirportIATACode());
        dto.setDepartureDate(flightEntity.getDepartureDate());
        return dto;
    }

    FlightEntity map(FlightEntityDto dto){
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightId(dto.getFlightId());
        flightEntity.setFlightNumber(dto.getFlightNumber());
        flightEntity.setCargoEntity(dto.getCargoEntity());
        flightEntity.setDepartureDate(dto.getDepartureDate());
        flightEntity.setArrivalAirportIATACode(dto.getArrivalAirportIATACode());
        flightEntity.setDepartureAirportIATACode(dto.getDepartureAirportIATACode());
        return flightEntity;
    }
}
