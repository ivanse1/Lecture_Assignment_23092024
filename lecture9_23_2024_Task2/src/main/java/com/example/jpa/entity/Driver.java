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

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
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
    public String toString() {
        return "Driver{id=" + id + ", name='" + name + '\'' + ", experience=" + experience + ", cars=" + cars + '}';
    }
}
