package com.example.jpa;

import com.example.jpa.entity.Car;
import com.example.jpa.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarDriverPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Students and Courses
        Driver driver1 = new Driver("John Doe", 5);
        Car car1 = new Car("Audi");

        // Set the one-to-one relationship
        driver1.setCar(car1);
        car1.setDriver(driver1);

        // Persist the entities
        em.persist(driver1);
        em.persist(car1);

        em.getTransaction().commit();

        // Retrieve and display
        Driver foundDriver = em.find(Driver.class, driver1.getId());
        System.out.println(foundDriver);

        em.close();
        emf.close();
    }
}
