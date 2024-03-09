package ru.rodionov.servlets.server.dto;

import lombok.*;

//@AllArgsConstructor
//@Getter
//@EqualsAndHashCode
//@ToString
//@Data
@Value
@Builder
public class FlightDTO {
    Long id;
    String description;

}
