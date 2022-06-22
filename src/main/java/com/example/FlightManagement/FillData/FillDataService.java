package com.example.FlightManagement.FillData;

import com.example.FlightManagement.Entities.CargoEntity;
import com.example.FlightManagement.Repository.BaggageRepository;
import com.example.FlightManagement.Repository.CargoEntityRepository;
import com.example.FlightManagement.Repository.CargoRepository;
import com.example.FlightManagement.Repository.FlightEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FillDataService {
    private final BaggageRepository baggageRepository;
    private final CargoRepository cargoRepository;
    private final CargoEntityRepository cargoEntityRepository;

    private final FlightEntityRepository flightEntityRepository;
    private final FillDataMapper fillDataMapper;


    public void addFlights(List<FlightEntityDto> dto) {
        dto
                .stream()
                .map(fillDataMapper::mapFlightEntityDtoToFlightEntity)
                .forEach(flightEntityRepository::save);
    }

    @Transactional
    public void addToFlightEntityCargoEntity(List<CargoEntityDto> dto) {
        dto
                .stream()
                .map(CargoEntityDto::getFlightId)
                .forEach(x -> flightEntityRepository.findById(x).get()
                        .setCargoEntity(cargoEntityRepository.findById(x).get()));
    }

    public void addCargos(List<CargoEntityDto> dto) {
        List<CargoEntity> cargoEntities = dto
                .stream()
                .map(fillDataMapper::mapCargoEntityDtoToCargoEntity).toList();

        cargoEntityRepository.saveAll(cargoEntities);

    }
}
