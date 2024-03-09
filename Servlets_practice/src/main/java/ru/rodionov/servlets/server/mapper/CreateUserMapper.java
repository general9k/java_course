package ru.rodionov.servlets.server.mapper;

import ru.rodionov.servlets.server.dto.CreateUserDTO;
import ru.rodionov.servlets.server.entity.Gender;
import ru.rodionov.servlets.server.entity.Role;
import ru.rodionov.servlets.server.entity.User;
import ru.rodionov.servlets.server.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDTO, User> {
    private static final String IMAGE_FOLDER = "users/";

    public static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDTO object) {
        return User
                .builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .birthDay(LocalDateFormatter.format(object.getBirthday()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
