package be.fgov.economie.sge.mapper;

import be.fgov.economie.sge.model.User;
import be.fgov.economie.sge.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto (User user);
    User userDtoToUser (UserDto userDto);
    List<UserDto> usersToDto(List<User> users);
}