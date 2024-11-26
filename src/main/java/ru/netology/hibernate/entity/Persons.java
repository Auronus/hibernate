package ru.netology.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Persons {
    @EmbeddedId
    private CompositeKey compositeKey;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "city_of_living")
    private String cityOfLiving;

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "compositeKey=" + compositeKey +
                ", phone_number='" + phoneNumber + '\'' +
                ", city_of_living='" + cityOfLiving + '\'' +
                '}';
    }

    public void setCompositeKey(CompositeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }
}