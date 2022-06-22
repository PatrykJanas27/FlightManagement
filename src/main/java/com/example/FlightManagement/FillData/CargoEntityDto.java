package com.example.FlightManagement.FillData;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CargoEntityDto {
    private final Long flightId;
    private final List<BaggageDto> baggage;
    private final List<CargoDto> cargo;
}
