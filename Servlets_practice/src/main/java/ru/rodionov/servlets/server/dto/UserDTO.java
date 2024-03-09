package ru.rodionov.servlets.server.dto;

import lombok.Builder;
import lombok.Value;
import ru.rodionov.servlets.server.entity.Gender;
import ru.rodionov.servlets.server.entity.Role;

import java.time.LocalDate;

@Value
@Builder
public class UserDTO {
    Integer id;
    String name;
    LocalDate birthDay;
    String email;
    String image;
    Role role;
    Gender gender;
}
