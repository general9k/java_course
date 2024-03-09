package ru.rodionov.servlets.server.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Objects;

@Value
@Builder
public class TicketDTO {
    Long id;
    Long flightId;
    String seatNo;
}
