package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.CompositeKey;
import ru.netology.hibernate.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonCrudRepository extends JpaRepository<Persons, CompositeKey> {
    @Query("select e from Persons e where LOWER(e.cityOfLiving) = :city")
    List<Persons> findByCityOfLiving(String city);

    @Query("select e from Persons e where e.compositeKey.age < :age order by e.compositeKey.age asc")
    List<Persons> findByCompositeKeyAgeLessThanWithOrderByCompositeKeyAge(int age);

    @Query("select e from Persons e where e.compositeKey.name = :name AND e.compositeKey.surname = :surname")
    Optional<Persons> findByCompositeKeyNameAndCompositeKeySurname(String name, String surname);
}
