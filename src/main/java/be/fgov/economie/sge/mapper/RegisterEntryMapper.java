package be.fgov.economie.sge.mapper;

import org.mapstruct.Mapper;

import java.time.*;
import java.util.List;

import be.fgov.economie.sge.model.RegisterEntry;
import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterEntryMapper {

    RegisterEntryMapper INSTANCE = Mappers.getMapper(RegisterEntryMapper.class);

    RegisterEntryDto registerEntryToDto (RegisterEntry registerEntry);
    RegisterEntry registerEntryDtoToRegisterEntry(RegisterEntryDto registerEntryDto);
    List<RegisterEntryDto> registerEntriesToRegisterEntriesDto(List<RegisterEntry> registerEntries);
    List<RegisterEntryDto> registerEntriesDtoToRegisterEntries(List<RegisterEntry> registerEntries);


    default LocalDateTime map(OffsetDateTime in){
        return in.toLocalDateTime();
    }

    default OffsetDateTime map(LocalDateTime in){
        return OffsetDateTime.of(in, ZoneOffset.UTC);

    // @Mapping(source = "date", target = "loadingDate")
    // @Mapping(source = "startTime", target = "loadingStartTime")
    // @Mapping(source = "stopTime", target = "loadingStopTime")
    //@Mapping(source = "quantity", target = "loadedQuantity")


    //@Mapping(source = "dateTime", target = "loadingDate")
    //@Mapping(source = "dateTime", target = "loadingTime")

    /*@Named("dtoWithSeparateDate")
    public static LocalDate dateTimeToDateOnly(LocalDateTime dateTime){
        LocalDate loadingDate = dateTime.toLocalDate();
        return loadingDate;
    }
    @Named("dtoWithSeparateTime")
    public static LocalTime dateTimeToTimeOnly(LocalDateTime dateTime){
        LocalTime loadingTime = dateTime.toLocalTime();
        return loadingTime;
    }*/


    }
}


