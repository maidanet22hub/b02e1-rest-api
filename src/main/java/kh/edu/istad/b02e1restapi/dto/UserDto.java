package kh.edu.istad.b02e1restapi.dto;

import java.util.UUID;
public record UserDto(
        UUID id,
        String fullName) {
}
