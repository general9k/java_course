package ru.rodionov.servlets.server.dto;

import jakarta.servlet.http.Part;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDTO {
    String name;
    String birthday;
    Part image;
    String email;
    String password;
    String role;
    String gender;
}
