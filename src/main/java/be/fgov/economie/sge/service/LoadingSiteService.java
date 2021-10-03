package be.fgov.economie.sge.service;


import be.fgov.economie.sge.mapper.LoadingSiteMapper;
import be.fgov.economie.sge.model.LoadingSite;
import be.fgov.economie.sge.model.dto.LoadingSiteDto;
import be.fgov.economie.sge.repository.LoadingSiteRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class LoadingSiteService {
    private final LoadingSiteRepository loadingSiteRepository;
    private final LoadingSiteMapper loadingSiteMapper;

    public LoadingSiteService (LoadingSiteRepository loadingSiteRepository) {
        this.loadingSiteRepository = loadingSiteRepository;
        this.loadingSiteMapper = Mappers.getMapper(LoadingSiteMapper.class);
    }

    public Iterable<LoadingSiteDto> getLoadingSites() {
        Iterable<LoadingSite> loadingSitesAll = loadingSiteRepository.findAll();
        Iterable<LoadingSiteDto> loadingSiteDtos = loadingSiteMapper.loadingSiteDtos(loadingSitesAll);
        return loadingSiteDtos;
    }
}
