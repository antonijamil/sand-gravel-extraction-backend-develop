package be.fgov.economie.sge.service;

import be.fgov.economie.sge.mapper.ShipMapper;
import be.fgov.economie.sge.model.Ship;
import be.fgov.economie.sge.model.dto.ShipDto;
import be.fgov.economie.sge.model.dto.response.SimpleResponseDto;
import be.fgov.economie.sge.repository.ShipRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipService {
    private final ShipRepository shipRepository;
    private final ShipMapper shipMapper;

    public ShipService (ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
        this.shipMapper = Mappers.getMapper(ShipMapper.class);
    }

    public SimpleResponseDto<ShipDto> getShips() {
        Iterable<Ship> ships = shipRepository.findAll();
        Iterable<ShipDto> shipDtos = shipMapper.shipDtoMap(ships);
        return new SimpleResponseDto<>(shipDtos);
    }

    public ShipDto getShipById(Integer id) {
        Optional<Ship> ships = shipRepository.findById(id);
        ShipDto shipDto = shipMapper.shipToShipDto(ships);
        return shipDto;
    }
}
