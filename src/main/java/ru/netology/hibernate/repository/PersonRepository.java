package ru.netology.hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Persons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Persons> getPersonsByCity(String city) {
        return findAll().stream()
                .filter(person -> person.getCity_of_living().equals(city))
                .toList();
    }

    private List<Persons> findAll() {
        TypedQuery<Persons> query = entityManager.createQuery("SELECT e FROM Persons e", Persons.class);
        return query.getResultList();
    }
}
