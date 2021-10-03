package be.fgov.economie.sge.mapper;

import be.fgov.economie.sge.model.Unloading;
import be.fgov.economie.sge.model.dto.UnloadingDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UnloadingMapper {
    UnloadingMapper INSTANCE = Mappers.getMapper(UnloadingMapper.class);

    UnloadingDto unloadingToUnloadingDto (Unloading unloading);
    Unloading unloadingDtoToUnloading (UnloadingDto unloadingDto);

    Iterable<UnloadingDto> map (Iterable<Unloading> unloading);
}
