package kh.edu.istad.b02e1restapi.service;

import kh.edu.istad.b02e1restapi.dto.UserDto;
import kh.edu.istad.b02e1restapi.dto.UserAddDto;
import kh.edu.istad.b02e1restapi.dto.UserUpdateDto;

import java.util.List;
import java.util.UUID;


public interface UserService {


    UserDto updateById(UUID id, UserUpdateDto request);
    // Define business logic

    void deleteById(UUID id);

    // 0. what is ur logic
    // 1. Return type
    // 2. Parameter type

    UserDto getById(UUID id);

    List<UserDto> getAll(String keyword);
    UserDto createUser(UserAddDto request);


}

