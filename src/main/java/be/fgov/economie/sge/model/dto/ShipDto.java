package be.fgov.economie.sge.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipDto {
    private Integer id;
    private Integer imo;
    private String name;
    private Integer hopperVolume;
}
