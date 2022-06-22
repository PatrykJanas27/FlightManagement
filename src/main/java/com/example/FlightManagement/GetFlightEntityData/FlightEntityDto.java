package com.example.FlightManagement.GetFlightEntityData;

import com.example.FlightManagement.Entities.CargoEntity;
import lombok.Data;

@Data
public class FlightEntityDto {
    private Long flightId;
    private Integer flightNumber;
    private CargoEntity cargoEntity;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private String departureDate;
}
