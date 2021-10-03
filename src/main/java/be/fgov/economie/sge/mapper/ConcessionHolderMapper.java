package be.fgov.economie.sge.mapper;

import be.fgov.economie.sge.model.ConcessionHolder;
import be.fgov.economie.sge.model.dto.ConcessionHolderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConcessionHolderMapper {
    ConcessionHolderMapper INSTANCE = Mappers.getMapper(ConcessionHolderMapper.class);


    ConcessionHolderDto ConcessionHolderToConcessionHolderDto (ConcessionHolder concessionHolder);
    ConcessionHolder ConcessionHolderDtoToConcessionHolder (ConcessionHolderDto concessionHolderDto);

    Iterable<ConcessionHolderDto> concessionHolderDtos(Iterable<ConcessionHolder> concessionHolders);
}
