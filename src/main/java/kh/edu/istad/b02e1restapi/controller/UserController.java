package kh.edu.istad.b02e1restapi.controller;

import kh.edu.istad.b02e1restapi.dto.UserAddDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import kh.edu.istad.b02e1restapi.dto.UserDto;
import kh.edu.istad.b02e1restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import kh.edu.istad.b02e1restapi.dto.UserUpdateDto;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
    }


    @PutMapping("/{id}")
    public UserDto updateById(
            @PathVariable UUID id,
            @RequestBody UserUpdateDto request
    ) {
        return userService.updateById(id, request);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getAll(
            @RequestParam(required = false, defaultValue = "") String keyword
    ) {
        return userService.getAll(keyword);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto createUser(@RequestBody UserAddDto request) {
        return userService.createUser(request);
    }

}