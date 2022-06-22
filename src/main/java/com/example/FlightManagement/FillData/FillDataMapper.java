package com.example.FlightManagement.FillData;

import com.example.FlightManagement.Entities.Baggage;
import com.example.FlightManagement.Entities.Cargo;
import com.example.FlightManagement.Entities.CargoEntity;
import com.example.FlightManagement.Entities.FlightEntity;
import com.example.FlightManagement.Repository.BaggageRepository;
import com.example.FlightManagement.Repository.CargoRepository;
import com.example.FlightManagement.Repository.FlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillDataMapper {

    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;
    private final FlightEntityRepository flightEntityRepository;

    public CargoEntity mapCargoEntityDtoToCargoEntity(CargoEntityDto dto) {
        CargoEntity cargoEntity = new CargoEntity();
        cargoEntity.setFlightId(dto.getFlightId());
        cargoEntity.setBaggage(dto.getBaggage().stream().map(this::mapBaggageDtoToBaggage).collect(Collectors.toList()));
        cargoEntity.setCargo(dto.getCargo().stream().map(this::mapCargoDtoToCargo).collect(Collectors.toList()));
        System.out.println(cargoEntity);
        return cargoEntity;
    }

    public FlightEntity mapFlightEntityDtoToFlightEntity(FlightEntityDto dto) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightId(dto.getFlightId());
        flightEntity.setCargoEntity(dto.getCargoEntity());
        flightEntity.setFlightNumber(dto.getFlightNumber());
        flightEntity.setArrivalAirportIATACode(dto.getArrivalAirportIATACode());
        flightEntity.setDepartureDate(dto.getDepartureDate());
        flightEntity.setDepartureAirportIATACode(dto.getDepartureAirportIATACode());
        return flightEntity;
    }

    public Cargo mapCargoDtoToCargo(CargoDto cargoDto) {
        Cargo value = Cargo
                .builder()
                .pieces(cargoDto.getPieces())
                .weight(cargoDto.getWeight())
                .weightUnit(cargoDto.getWeightUnit())
                .build();
        cargoRepository.save(value);
        return value;

    }

    public Baggage mapBaggageDtoToBaggage(BaggageDto baggageDto) {
        Baggage baggage =
                Baggage
                        .builder()
                        .pieces(baggageDto.getPieces())
                        .weight(baggageDto.getWeight())
                        .weightUnit(baggageDto.getWeightUnit())
                        .build();
        baggageRepository.save(baggage);
        return baggage;
    }
}

