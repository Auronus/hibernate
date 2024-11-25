package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.PersonCrudRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping ("/test")
@RestController
public class TestController {
    @Autowired
    private PersonCrudRepository repository;

    @Secured("ROLE_READ")
    @GetMapping("/role_read")
    public String getPersonsByCity() {
        return "Вы вызвали метод @Secured(\"ROLE_READ\")";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/role_write")
    public String getPersonsByAge() {
        return "Вы вызвали метод @RolesAllowed(\"ROLE_WRITE\")";
    }

    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @GetMapping("/role_write_or_role_delete")
    public String getPersonsByNameAndSurname() {
        return "Вы вызвали метод @PreAuthorize(\"hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')\")";
    }

    @PostAuthorize("returnObject.username == authentication.principal.username")
    @GetMapping("/username")
    public String getPersonsByNameAndSurname(String username) {
        return "Вы вызвали метод @PostAuthorize(\"returnObject.username == authentication.principal.username\")";
    }
}
