package be.fgov.economie.sge.mapper;

import org.mapstruct.Mapper;
import be.fgov.economie.sge.model.Captain;
import be.fgov.economie.sge.model.dto.CaptainDto;

import java.util.List;

@Mapper
public interface CaptainMapper {
    CaptainDto captainToCaptainDto(Captain captain);
    Captain captainDtoToCaptain(CaptainDto captainDto);
    Iterable<CaptainDto> listCaptainsToDto(Iterable<Captain> captains);
}
