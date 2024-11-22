package ru.netology.hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Embeddable
public class CompositeKey implements Serializable {

    private String name;
    private String surname;
    private int age;

    public CompositeKey(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public CompositeKey() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKey that = (CompositeKey) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

}
