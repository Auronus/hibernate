package ru.netology.hibernate.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Persons {
    @EmbeddedId
    private CompositeKey compositeKey;
    private String phone_number;
    private String city_of_living;

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getCity_of_living() {
        return city_of_living;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "compositeKey=" + compositeKey +
                ", phone_number='" + phone_number + '\'' +
                ", city_of_living='" + city_of_living + '\'' +
                '}';
    }
}

@Embeddable
class CompositeKey implements Serializable {

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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}