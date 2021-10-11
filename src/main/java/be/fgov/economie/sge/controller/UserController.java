package be.fgov.economie.sge.controller;

import be.fgov.economie.sge.model.dto.ShipDto;
import be.fgov.economie.sge.model.dto.UserDto;
import be.fgov.economie.sge.model.dto.response.SimpleResponseDto;
import be.fgov.economie.sge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/list-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @PostMapping(value = "/new-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {

        UserDto createdUserDto = userService.registerNewUser(userDto);
        return ResponseEntity.ok(createdUserDto);

    }}