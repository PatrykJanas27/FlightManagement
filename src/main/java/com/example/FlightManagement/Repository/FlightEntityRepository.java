package com.example.FlightManagement.Repository;

import com.example.FlightManagement.Entities.FlightEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightEntityRepository extends CrudRepository<FlightEntity, Long> {
    FlightEntity findByFlightNumberAndDepartureDate(Integer flightNumber, String departureDate);
    List<FlightEntity> findAllByDepartureAirportIATACodeAndDepartureDate(String departureAirportIATACode, String departureDate);
    List<FlightEntity> findAllByArrivalAirportIATACodeAndDepartureDate(String arrivalAirportIATACode, String departureDate);

}
