package com.example.FlightManagement.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightEntity {
    @Id
    private Long flightId;
    @NotNull
    private Integer flightNumber;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JsonIgnore
    @ToString.Exclude
    private CargoEntity cargoEntity;
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 3)
    private String departureAirportIATACode;
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 3)
    private String arrivalAirportIATACode;
    @NotNull
    private String departureDate;
}
