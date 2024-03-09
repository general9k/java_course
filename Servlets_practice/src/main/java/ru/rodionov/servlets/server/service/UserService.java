package ru.rodionov.servlets.server.service;

import lombok.SneakyThrows;
import ru.rodionov.servlets.server.dao.UserDAO;
import ru.rodionov.servlets.server.dto.CreateUserDTO;
import ru.rodionov.servlets.server.dto.UserDTO;
import ru.rodionov.servlets.server.entity.User;
import ru.rodionov.servlets.server.exception.ValidationException;
import ru.rodionov.servlets.server.mapper.CreateUserMapper;
import ru.rodionov.servlets.server.mapper.UserMapper;
import ru.rodionov.servlets.server.validator.CreateUserValidator;
import ru.rodionov.servlets.server.validator.ValidationResult;

import java.util.Optional;

public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDAO userDAO = UserDAO.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();
    private final UserMapper userMapper = UserMapper.getInstance();
    private final ImageService imageService = ImageService.getInstance();

    private UserService() {

    }

    @SneakyThrows
    public Integer create(CreateUserDTO createUserDTO) {
        ValidationResult valid = createUserValidator.isValid(createUserDTO);
        if (!valid.isValid()) {
            throw new ValidationException(valid.getErrors());
        }
        User user = createUserMapper.mapFrom(createUserDTO);
        imageService.upload(user.getImage(), createUserDTO.getImage().getInputStream());
        userDAO.save(user);
        return user.getId();
    }

    public Optional<UserDTO> login(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password)
                .map(userMapper::mapFrom);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
