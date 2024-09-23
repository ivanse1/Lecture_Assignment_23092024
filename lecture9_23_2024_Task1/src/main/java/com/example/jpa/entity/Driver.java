package com.example.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience;

    @OneToOne(mappedBy = "driver")
    private Car car;

    public Driver() {}
    public Driver(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    // Getters and Setters
    public void setCar(Car car1) {
        this.car = car1;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "Driver{id=" + id + ", name='" + name + '\'' + ", experience=" + experience + ", car=" + car.getModel() + '}';
    }
}
