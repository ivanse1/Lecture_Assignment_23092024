package com.example.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToMany(mappedBy = "cars")
    private List<Driver> drivers = new ArrayList<>();

    public Car() {}
    public Car(String model) {
        this.model = model;
    }
    // Getters and Setters
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
    public Long getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public String toString() {
        String r = "Car{id=" + id + ", model='" + model + '\'' + ", drivers= [";
        for (Driver d : drivers) {
            r += "{" + d.getId() + ", " + d.getName() + ", " + d.getExperience() + "} ,";
        }
        return r.substring(0, r.length() - 2) + "]}";
    }
}
