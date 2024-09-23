package com.example.jpa;

import com.example.jpa.entity.Car;
import com.example.jpa.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarDriverPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Students and Courses
        Driver driver1 = new Driver("John Doe", 5);
        Driver driver2 = new Driver("Ken Miles", 20);
        Car car1 = new Car("Audi");
        Car car2 = new Car("Ford");

        // Set the one-to-one relationship
        driver1.setCars(Arrays.asList(car1, car2));
        driver2.setCars(Arrays.asList(car1, car2));
        car1.setDrivers(Arrays.asList(driver1, driver2));
        car2.setDrivers(Arrays.asList(driver1, driver2));

        // Persist the entities
        em.persist(driver1);
        em.persist(driver2);
        em.persist(car1);
        em.persist(car2);

        em.getTransaction().commit();

        // Retrieve and display
        Driver foundDriver1 = em.find(Driver.class, driver1.getId());
        System.out.println(foundDriver1);

        em.close();
        emf.close();
    }
}
