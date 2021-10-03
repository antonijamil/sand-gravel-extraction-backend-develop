package be.fgov.economie.sge.model.dto;

import be.fgov.economie.sge.model.RegisterEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnloadingDto {
    private Long id;
    private String destinationCountry;
    private String destination;
    private Long unloadedVolume;
    private String unloadingPlace;
    //private RegisterEntryDto registerEntry;
    //private RegisterEntryDto registerEntryDto;
}
