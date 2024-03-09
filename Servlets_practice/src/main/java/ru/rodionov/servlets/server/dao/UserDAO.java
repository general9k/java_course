package ru.rodionov.servlets.server.dao;

import lombok.SneakyThrows;
import ru.rodionov.servlets.server.entity.Gender;
import ru.rodionov.servlets.server.entity.Role;
import ru.rodionov.servlets.server.entity.User;
import ru.rodionov.servlets.server.util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDAO implements DAO<Integer, User> {

    private static final UserDAO INSTANCE = new UserDAO();

    private static final String SAVE_SQL = """
            INSERT INTO users(name, birthday, email, password, role, gender, image) VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL = """
            SELECT * FROM users WHERE email = ? AND password = ?
            """;

    private UserDAO() {
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @SneakyThrows
    public Optional<User> findByEmailAndPassword(String email, String password) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            User user = null;
            if (resultSet.next()) {
                user = buildEntity(resultSet);
            }
            return Optional.ofNullable(user);
        }
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement statement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {
            statement.setObject(1, entity.getName());
            statement.setObject(2, entity.getBirthDay());
            statement.setObject(3, entity.getEmail());
            statement.setObject(4, entity.getPassword());
            statement.setObject(5, entity.getRole().name());
            statement.setObject(6, entity.getGender().name());
            statement.setObject(7, entity.getImage());


            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();

            entity.setId(generatedKeys.getObject("id", Integer.class));

            return entity;

        }
    }


    public static UserDAO getInstance() {
        return INSTANCE;
    }

    private static User buildEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getObject("id", Integer.class))
                .name(resultSet.getObject("name", String.class))
                .birthDay(resultSet.getObject("birthday", Date.class).toLocalDate())
                .email(resultSet.getObject("email", String.class))
                .image(resultSet.getObject("image", String.class))
                .password(resultSet.getObject("password", String.class))
                .role(Role.find(resultSet.getObject("role", String.class)).orElse(null))
                .gender(Gender.valueOf(resultSet.getObject("gender", String.class)))
                .build();
    }
}
