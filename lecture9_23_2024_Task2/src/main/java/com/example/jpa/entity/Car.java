package com.example.jpa.entity;

import jakarta.persistence.*;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;

    public Car() {}
    public Car(String model) {
        this.model = model;
    }
    // Getters and Setters
    public void setDriver(Driver driver1) {
        this.driver = driver1;
    }
    public Long getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public String toString() {
        return "Car{id=" + id + ", model='" + model + '\'' + ", driver=" + driver.getName() + '}';
    }
}
