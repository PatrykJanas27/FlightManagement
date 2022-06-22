package com.example.FlightManagement.GetBaggageData;

import lombok.Data;

@Data
class BaggageDto {
    private Long id;
    private Integer weight;
    private String weightUnit;
    private Integer pieces;
}
