package be.fgov.economie.sge.service;

import be.fgov.economie.sge.mapper.UserMapper;
import be.fgov.economie.sge.model.User;
import be.fgov.economie.sge.model.dto.CaptainDto;
import be.fgov.economie.sge.model.dto.UserDto;
import be.fgov.economie.sge.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = userMapper.usersToDto(users);
        return usersDto;
    }

    public UserDto saveUser (UserDto userDto) {

        User user = userMapper.userDtoToUser(userDto);
        User userSaved = this.userRepository.save(user);

        return userMapper.userToUserDto(userSaved);
    }
}