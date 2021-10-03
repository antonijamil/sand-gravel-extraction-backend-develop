package be.fgov.economie.sge.service;

import be.fgov.economie.sge.mapper.ConcessionHolderMapper;
import be.fgov.economie.sge.model.ConcessionHolder;
import be.fgov.economie.sge.model.dto.ConcessionHolderDto;
import be.fgov.economie.sge.model.dto.response.SimpleResponseDto;
import be.fgov.economie.sge.repository.ConcessionHolderRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ConcessionHolderService {

    private final ConcessionHolderRepository concessionHolderRepository;
    private final ConcessionHolderMapper concessionHolderMapper;

    public ConcessionHolderService (ConcessionHolderRepository concessionHolderRepository) {
        this.concessionHolderRepository = concessionHolderRepository;
        this.concessionHolderMapper = Mappers.getMapper(ConcessionHolderMapper.class);
    }

    public SimpleResponseDto<ConcessionHolderDto> getConcessionHolders() {
        Iterable<ConcessionHolder> concessionHolders = concessionHolderRepository.findAll();
        Iterable<ConcessionHolderDto> concessionHoldersDtos = concessionHolderMapper.concessionHolderDtos(concessionHolders);
        return new SimpleResponseDto<>(concessionHoldersDtos);
    }
}
