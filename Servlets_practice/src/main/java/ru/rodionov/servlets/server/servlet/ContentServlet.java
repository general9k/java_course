package ru.rodionov.servlets.server.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.rodionov.servlets.server.dto.FlightDTO;
import ru.rodionov.servlets.server.service.FlightService;
import ru.rodionov.servlets.server.util.JspHelper;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.*;

@WebServlet("/content")
public class ContentServlet extends HttpServlet {

    private static final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FlightDTO> flightDTOS = flightService.findAll();
        req.setAttribute("flights", flightDTOS);
        req.getSession().setAttribute("flightsMap", flightDTOS.stream()
                .collect(toMap(FlightDTO::getId, FlightDTO::getDescription)));

        req.getRequestDispatcher(JspHelper.getPath("content"))
                .forward(req, resp);
    }
}
