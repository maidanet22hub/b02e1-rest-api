package kh.edu.istad.b02e1restapi.dto;


public record UserAddDto(
        String username,
        String password,
        String fullName
) {
}