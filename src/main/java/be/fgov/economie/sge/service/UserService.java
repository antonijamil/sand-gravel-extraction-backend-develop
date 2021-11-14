package be.fgov.economie.sge.service;

import be.fgov.economie.sge.mapper.UserMapper;
import be.fgov.economie.sge.model.User;
import be.fgov.economie.sge.model.dto.UserDto;
import be.fgov.economie.sge.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = Mappers.getMapper(UserMapper.class);
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = userMapper.usersToDto(users);
        return usersDto;
    }

    private PasswordEncoder passwordEncoder;

    public UserDto registerNewUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setActive(1);
        User saved = this.userRepository.save(user);

        return userMapper.userToUserDto(saved);
    }

    public UserDto findByUsername(String username){
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        user.setPassword(null);
        return userMapper.userToUserDto(user);
    }

}
