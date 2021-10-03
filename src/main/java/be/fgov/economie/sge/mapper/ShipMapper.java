package be.fgov.economie.sge.mapper;

import be.fgov.economie.sge.model.Ship;
import be.fgov.economie.sge.model.dto.ShipDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface ShipMapper {
    ShipMapper INSTANCE = Mappers.getMapper(ShipMapper.class);

    ShipDto shipToShipDto (Optional<Ship> ship);
    Ship shipDtoToShip (ShipDto shipDto);

    Iterable<ShipDto> shipDtoMap(Iterable<Ship> ship);
}
