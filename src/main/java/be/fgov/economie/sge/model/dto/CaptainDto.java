package be.fgov.economie.sge.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptainDto {
    private Integer id;
    private String name;
    private String address;

    /*private List<CaptainDto> captainDtos = new ArrayList<>();
    public void setCaptainDto(List<CaptainDto> captains) {
        this.captainDtos = captains;
    }*/


    //public void setId(Long id) { this.id = id; }
    //public Long getId() { return id; }

    /*public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }*/
}
