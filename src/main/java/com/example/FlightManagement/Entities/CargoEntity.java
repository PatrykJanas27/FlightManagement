package com.example.FlightManagement.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoEntity {
    @Id
    private Long flightId;
    @OneToOne(cascade = CascadeType.PERSIST)
    private FlightEntity flightEntity;
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Baggage> baggage;
    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Cargo> cargo;
}
