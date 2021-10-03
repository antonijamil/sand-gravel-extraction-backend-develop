package be.fgov.economie.sge.mapper;

import be.fgov.economie.sge.model.ConcessionHolder;
import be.fgov.economie.sge.model.LoadingSite;
import be.fgov.economie.sge.model.dto.ConcessionHolderDto;
import be.fgov.economie.sge.model.dto.LoadingSiteDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoadingSiteMapper {
    LoadingSiteMapper INSTANCE = Mappers.getMapper(LoadingSiteMapper.class);

    LoadingSiteDto LoadingSiteToLoadingSiteDto (LoadingSite loadingSite);
    LoadingSite LoadingSiteDtoToLoadingSite (LoadingSiteDto loadingSiteDto);

    Iterable<LoadingSiteDto> loadingSiteDtos(Iterable<LoadingSite> loadingSites);
}
