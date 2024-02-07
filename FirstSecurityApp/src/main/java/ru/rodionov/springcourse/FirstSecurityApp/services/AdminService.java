package ru.rodionov.springcourse.FirstSecurityApp.services;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

// Пример того как можно навешивать авторизацию на методы
@Service
public class AdminService {
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')") // метод сработает только у admin
    public void doAdminStaff() {
        System.out.println("Only admin here");
    }
}
