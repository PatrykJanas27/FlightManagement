package com.example.FlightManagement.GetCargoData;

import lombok.Data;

@Data
public class CargoDto {
    private Long id;
    private Integer weight;
    private String weightUnit;
    private Integer pieces;
}
