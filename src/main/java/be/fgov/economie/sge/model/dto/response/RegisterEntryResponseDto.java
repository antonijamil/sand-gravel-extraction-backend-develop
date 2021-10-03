package be.fgov.economie.sge.model.dto.response;

import be.fgov.economie.sge.model.dto.RegisterEntryDto;
import lombok.Data;

import java.util.List;
@Data
public class RegisterEntryResponseDto {

    private int page;

    private int pageSize;

    private int total;

    private List<RegisterEntryDto> data;

}
