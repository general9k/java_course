package ru.rodionov.servlets.server.service;

import ru.rodionov.servlets.server.dao.TicketDAO;
import ru.rodionov.servlets.server.dto.TicketDTO;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TicketService {
    private static final TicketService INSTANCE = new TicketService();
    private static TicketDAO ticketDAO = TicketDAO.getInstance();

    private TicketService() {

    }

    public List<TicketDTO> findAllByFlightId(Long flightId) {
        return ticketDAO.findAllByFlightId(flightId).stream().map(ticket -> TicketDTO.builder().id(ticket.getId()).flightId(ticket.getFlightId())
                .seatNo(ticket.getSeatNo()).build()).collect(toList());
    }

    public static TicketService getInstance() {
        return INSTANCE;
    }
}
