package be.fgov.economie.sge.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadingSiteDto {
    private Integer id;
    private String name;
    private Character status;
}
