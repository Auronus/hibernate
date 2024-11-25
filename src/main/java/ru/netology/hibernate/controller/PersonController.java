package ru.netology.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @GetMapping("/persons/by-city")
    public List<Persons> getAuthorities(String name) {
        return repository.getPersonsByCity(name);
    }
}
