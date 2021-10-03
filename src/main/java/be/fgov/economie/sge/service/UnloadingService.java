package be.fgov.economie.sge.service;

import be.fgov.economie.sge.mapper.UnloadingMapper;
import be.fgov.economie.sge.model.Unloading;
import be.fgov.economie.sge.model.dto.UnloadingDto;
import be.fgov.economie.sge.repository.UnloadingRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class UnloadingService {
    private final UnloadingRepository unloadingRepository;
    private final UnloadingMapper unloadingMapper;

    public UnloadingService(UnloadingRepository unloadingRepository) {
        this.unloadingRepository = unloadingRepository;
        this.unloadingMapper = Mappers.getMapper(UnloadingMapper.class);
    }

    public Iterable<UnloadingDto> getUnloadings() {
        Iterable<Unloading> all = unloadingRepository.findAll();
        Iterable<UnloadingDto> unloadingDtos = unloadingMapper.map(all);
        return unloadingDtos;
    }
}
