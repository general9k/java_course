package ru.rodionov.servlets.server.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramValue = req.getParameter("param");
        Map<String, String[]> map = req.getParameterMap();
        System.out.println();

//        Enumeration<String> headerNames = req.getHeaderNames();
//        StringBuilder builder = new StringBuilder();
//        while (headerNames.hasMoreElements()) {
//            builder.append(headerNames.nextElement()).append("</br>");
//        }
        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("token", "12345");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>Hello from first servlet</h1>");
//            writer.write("</br>");
//            writer.write(new String(builder));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (BufferedReader reader = req.getReader();
             Stream<String> stream = reader.lines()) {
            stream.forEach(System.out::println);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
