package be.fgov.economie.sge.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String address;
    private Integer active;
    private String roles;
    private String permissions;



}
