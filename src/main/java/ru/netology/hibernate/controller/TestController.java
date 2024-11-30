package ru.netology.hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping ("/test")
@RestController
public class TestController {

    @Secured("ROLE_READ")
    @GetMapping("/role_read")
    public String roleRead() {
        return "Вы вызвали метод @Secured(\"ROLE_READ\")";
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/role_write")
    public String rolesAllowedRoleWrite() {
        return "Вы вызвали метод @RolesAllowed(\"ROLE_WRITE\")";
    }

    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    @GetMapping("/role_write_or_role_delete")
    public String roleWriteOrRoleDelete() {
        return "Вы вызвали метод @PreAuthorize(\"hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')\")";
    }

    @PostAuthorize("#username == authentication.principal.username")
    @GetMapping("/username")
    public String getUsername(String username) {
        return "Вы вызвали метод @PostAuthorize(\"#username == authentication.principal.username\")";
    }
}
