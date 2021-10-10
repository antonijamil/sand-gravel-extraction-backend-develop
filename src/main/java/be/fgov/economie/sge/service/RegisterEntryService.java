package be.fgov.economie.sge.service;

import be.fgov.economie.sge.exception.RestResponseEntityExceptionHandler;
import be.fgov.economie.sge.model.*;
import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import be.fgov.economie.sge.model.dto.response.RegisterEntryResponseDto;
import be.fgov.economie.sge.repository.UnloadingRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import be.fgov.economie.sge.repository.RegisterEntryRepository;
import be.fgov.economie.sge.mapper.RegisterEntryMapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class RegisterEntryService {

    private final RegisterEntryRepository registerEntryRepository;
    private final RegisterEntryMapper registerEntryMapper;
    private final UnloadingRepository unloadingRepository;

    public RegisterEntryService(RegisterEntryRepository registerEntryRepository, UnloadingRepository unloadingRepository) {
        this.registerEntryRepository = registerEntryRepository;
        this.unloadingRepository = unloadingRepository;
        this.registerEntryMapper = Mappers.getMapper(RegisterEntryMapper.class);
    }

    public Optional<RegisterEntryDto> getRegisterEntryById(Integer id) {
        Optional<RegisterEntryDto> result = Optional.empty();
        Optional<RegisterEntry> registerEntryEntity = registerEntryRepository.findById(id);
        if (registerEntryEntity.isPresent()) {
            result = Optional.of(registerEntryMapper.registerEntryToDto(registerEntryEntity.get()));
        }
        return result;
    }

    public RegisterEntryResponseDto getRegisterEntriesByParams(Integer id, Long tripNumber, Integer shipId, Integer captainId,
                                                             Integer concessionHolderNumber, Integer loadingSiteId,
                                                             LocalDateTime startDateTime, LocalDateTime stopDateTime,
                                                             Integer loadedQuantity, String destination, String destinationCountry,
                                                             Integer page, Integer pageSize, String sortField) {

        Page<RegisterEntry> registerEntries;

        if (destination==null || destination.isEmpty()) {
           registerEntries = registerEntryRepository.findRegisterEntryByParams(id, tripNumber, shipId,
                    captainId, concessionHolderNumber, loadingSiteId, startDateTime, stopDateTime, loadedQuantity,
                    PageRequest.of(page, pageSize, Sort.by(sortField).ascending()));


        } else {
            registerEntries = registerEntryRepository.findRegisterEntryByParams(id, tripNumber, shipId,
                    captainId, concessionHolderNumber, loadingSiteId, startDateTime, stopDateTime, loadedQuantity, destination,
                    destinationCountry,  PageRequest.of(page, pageSize, Sort.by(sortField).ascending()));

        }

        RegisterEntryResponseDto response = new RegisterEntryResponseDto();
        response.setData(this.registerEntryMapper.toDto(registerEntries.getContent()));
        response.setPage(page);
        response.setPageSize(pageSize);

        //There should not be more than 2E9 elements in the database...
        response.setTotal((int)registerEntries.getTotalElements());

        return response;

    }

    public RegisterEntryDto saveRegisterEntry(RegisterEntryDto registerEntryDto) {

        RegisterEntry registerEntry = registerEntryMapper.registerEntryDtoToRegisterEntry(registerEntryDto);

        List<Unloading> unloadings = registerEntry.getUnloadings();
        registerEntry.setUnloadings(Collections.emptyList());

        RegisterEntry saved = this.registerEntryRepository.save(registerEntry);
        for(Unloading unloading : unloadings){
            unloading.setRegisterEntry(saved);
            unloadingRepository.save(unloading);
        }
        return registerEntryMapper.registerEntryToDto(saved);
    }

    /*public RegisterEntryDto createRegisterEntry(RegisterEntryDto registerEntryDto) {
        this.registerEntryDataValidation
    }
        /*public RegisterEntryDto getRegisterEntryById(Integer id) {
        RegisterEntry registerEntry = registerEntryRepository.findById(id).get();
        //if (registerEntry==null) {
            //throw new RestResponseEntityExceptionHandler(RegisterEntry.class, "id", id.toString());
        //}
        RegisterEntryDto registerEntryDto = registerEntryMapper.registerEntryToDto(registerEntry);
        return registerEntryDto;
    }*/
}
