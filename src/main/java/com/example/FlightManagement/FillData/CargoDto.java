package com.example.FlightManagement.FillData;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CargoDto {
    final private Long id;
    final private Integer weight;
    final private String weightUnit;
    final private Integer pieces;
}
