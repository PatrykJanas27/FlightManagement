package com.example.FlightManagement.FillData;

import com.example.FlightManagement.Entities.CargoEntity;
import lombok.Data;

@Data
public class FlightEntityDto {
    private final Long flightId;
    private final Integer flightNumber;
    private final CargoEntity cargoEntity;
    private final String departureAirportIATACode;
    private final String arrivalAirportIATACode;
    private final String departureDate;
}
