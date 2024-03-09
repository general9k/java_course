package ru.rodionov.servlets.server.service;


import ru.rodionov.servlets.server.dao.FlightDAO;
import ru.rodionov.servlets.server.dto.FlightDTO;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    private final FlightDAO flightDAO = FlightDAO.getInstance();

    public List<FlightDTO> findAll() {
        return flightDAO.findAll().stream()
                .map(flight -> FlightDTO.builder()
                        .id(flight.getId())
                        .description(
                                """
                                            %s - %s - %s
                                        """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))
                        .build())
                .collect(toList());
    }


    public static FlightService getInstance() {
        return INSTANCE;
    }
}
