package be.fgov.economie.sge.service;

import be.fgov.economie.sge.mapper.CaptainMapper;
import be.fgov.economie.sge.model.Captain;
import be.fgov.economie.sge.model.dto.CaptainDto;
import be.fgov.economie.sge.repository.CaptainRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class CaptainService {
    private final CaptainRepository captainRepository;
    private final CaptainMapper captainMapper;

    public CaptainService(CaptainRepository captainRepository) {
        this.captainRepository = captainRepository;
        this.captainMapper = Mappers.getMapper(CaptainMapper.class);
    }

    public CaptainDto getCaptainById(Integer id) {
        Captain captain = captainRepository.findById(id).get();
        CaptainDto captainDto = captainMapper.captainToCaptainDto(captain);
        return captainDto;
    }

    public CaptainDto getCaptainByName(String name){
        Captain captain = captainRepository.findByName(name);
        CaptainDto captainDto = captainMapper.captainToCaptainDto(captain);
        return captainDto;
    }

    public Captain getCaptainByNameTest(String name){
        return captainRepository.findByName(name);
    }

    public Iterable<CaptainDto> getCaptains() {
        Iterable<Captain> captains = captainRepository.findAll();
        Iterable<CaptainDto> captainDto = captainMapper.listCaptainsToDto(captains);
        return captainDto;
    }
}
