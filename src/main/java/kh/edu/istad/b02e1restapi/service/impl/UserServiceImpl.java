package kh.edu.istad.b02e1restapi.service.impl;

import java.util.UUID;
import kh.edu.istad.b02e1restapi.dto.UserDto;
import kh.edu.istad.b02e1restapi.model.User;

import kh.edu.istad.b02e1restapi.repository.UserRepository;
import kh.edu.istad.b02e1restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import kh.edu.istad.b02e1restapi.dto.UserAddDto;
import kh.edu.istad.b02e1restapi.dto.UserUpdateDto;

import java.util.List;

// User Service Implementation
@Service // refer to business logic and transaction
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto updateById(UUID id, UserUpdateDto request) {

        User oldUser = userRepository.select()
                .stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        User updatedUser = new User(
                oldUser.id(),
                oldUser.username(),
                oldUser.password(),
                request.fullName()
        );

        userRepository.select().remove(oldUser);
        userRepository.insert(updatedUser);

        return new UserDto(updatedUser.id(), updatedUser.fullName());
    }

    @Override
    public void deleteById(UUID id) {
        boolean isFound = userRepository.select()
                .stream()
                .anyMatch(user -> user.id().equals(id));

        IO.println("User with ID " + id + " is found: " + isFound);

        if (isFound)
            userRepository.select().removeIf(user -> user.id().equals(id));
        else
            throw new RuntimeException("User not found");
    }


    @Override
    public UserDto getById(UUID id) {
        // TODO: Implement logic to retrieve user by ID
        return userRepository.select()
                .stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .map(user -> new UserDto(user.id(), user.fullName()))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDto> getAll(String keyword) {
        return userRepository.select()
                .stream()
                .filter(user -> user.fullName().toLowerCase()
                        .contains(keyword.toLowerCase())
                )
                .map(user -> new UserDto(user.id(), user.fullName())).toList();
    }
    @Override
    public UserDto createUser(UserAddDto request) {

        User user = new User(
                UUID.randomUUID(),
                request.username(),
                request.password(),
                request.fullName()
        );

        userRepository.insert(user);

        return new UserDto(user.id(), user.fullName());
    }
}
