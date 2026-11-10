package kh.edu.istad.b02e1restapi.model;

import java.util.UUID;

public record User(
        UUID id,
        String username,
        String password,
        String fullName
) {
}