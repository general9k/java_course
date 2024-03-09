package ru.rodionov.servlets.server.dao;

import ru.rodionov.servlets.server.entity.Flight;
import ru.rodionov.servlets.server.entity.FlightStatus;
import ru.rodionov.servlets.server.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDAO implements DAO<Long, Flight> {

    private static final FlightDAO INSTANCE = new FlightDAO();

    private static final String FIND_ALL = """
            SELECT *
            FROM flight
            """;

    private FlightDAO() {

    }

    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Flight> flights = new ArrayList<>();

            while (resultSet.next()) {
                flights.add(buildFlight(resultSet));
            }

            return flights;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Flight entity) {

    }

    @Override
    public Flight save(Flight entity) {
        return null;
    }

    public static FlightDAO getInstance() {
        return INSTANCE;
    }

    private Flight buildFlight(ResultSet resultSet) throws SQLException {
        return new Flight(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("flight_no", String.class),
                resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("departure_airport_code", String.class),
                resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("arrival_airport_code", String.class),
                resultSet.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(resultSet.getObject("status", String.class))
        );
    }
}
