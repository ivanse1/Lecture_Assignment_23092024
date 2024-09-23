package com.example.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @ManyToMany
    @JoinTable(
            name = "driver_car",
            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id")
    )
    private List<Car> cars = new ArrayList<>();

    public Driver() {}
    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    // Getters and Setters
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    public String toString() {
        return "Driver{id=" + id + ", name='" + name + '\'' + ", experience=" + experience + ", cars=" + cars + '}';
    }
}
