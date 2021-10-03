package be.fgov.economie.sge.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConcessionHolderDto {
    private Integer id;
    private Integer concessionHolderNumber;
    private String name;
    private String address;
}
