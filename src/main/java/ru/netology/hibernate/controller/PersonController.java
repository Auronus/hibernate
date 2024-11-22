package ru.netology.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Persons;
import ru.netology.hibernate.repository.PersonCrudRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonCrudRepository repository;

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCity(String city) {
        return repository.findByCityOfLiving(city);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getPersonsByAge(int age) {
        return repository.findByCompositeKeyAgeLessThanWithOrderByCompositeKeyAge(age);
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<Persons> getPersonsByNameAndSurname(String name, String surname) {
        return repository.findByCompositeKeyNameAndCompositeKeySurname(name, surname);
    }
}
