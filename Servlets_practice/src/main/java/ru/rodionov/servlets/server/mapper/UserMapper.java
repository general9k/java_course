package ru.rodionov.servlets.server.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.rodionov.servlets.server.dto.UserDTO;
import ru.rodionov.servlets.server.entity.User;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserMapper implements Mapper<User, UserDTO> {
    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDTO mapFrom(User object) {
        return UserDTO.builder()
                .id(object.getId())
                .name(object.getName())
                .image(object.getImage())
                .birthDay(object.getBirthDay())
                .email(object.getEmail())
                .role(object.getRole())
                .gender(object.getGender())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
