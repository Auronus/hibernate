package ru.netology.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Persons {
    @EmbeddedId
    private CompositeKey compositeKey;
    private String phone_number;
    @Column(name = "city_of_living")
    private String cityOfLiving;

    @Override
    public String toString() {
        return "Persons{" +
                "compositeKey=" + compositeKey +
                ", phone_number='" + phone_number + '\'' +
                ", city_of_living='" + cityOfLiving + '\'' +
                '}';
    }

    public CompositeKey getCompositeKey() {
        return compositeKey;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }
}