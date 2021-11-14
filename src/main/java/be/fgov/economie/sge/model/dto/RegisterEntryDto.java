package be.fgov.economie.sge.model.dto;

import be.fgov.economie.sge.service.RegisterEntryService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import lombok.Data;

import java.sql.Time;
import java.time.*;
import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterEntryDto {
    private Integer id;
    private Long tripNumber;
    private OffsetDateTime startDateTime;
    private OffsetDateTime stopDateTime;
    private Integer loadedQuantity;
    private String deviantVolume;

    private UserDto user;
    private ConcessionHolderDto concessionHolder;
    private LoadingSiteDto loadingSite;
    private ShipDto ship;

    List<UnloadingDto> unloadings;
}
