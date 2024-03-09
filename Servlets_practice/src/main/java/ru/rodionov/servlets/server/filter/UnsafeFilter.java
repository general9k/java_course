package ru.rodionov.servlets.server.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.rodionov.servlets.server.dto.UserDTO;

import java.io.IOException;

@WebFilter("/admin")
public class UnsafeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UserDTO user = (UserDTO) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            ((HttpServletResponse) servletResponse).sendRedirect("/registration");
        }

    }
}
