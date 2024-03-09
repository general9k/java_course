package ru.rodionov.servlets.server.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.rodionov.servlets.server.dto.UserDTO;

import java.io.IOException;

@WebServlet("/sessions")
public class SessionServlet extends HttpServlet {
    private static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute(USER);
        if (user == null) {
            user = UserDTO
                    .builder()
                    .id(25)
                    .email("test@gmail.com")
                    .build();
            session.setAttribute(USER, user);
        }
    }
}
