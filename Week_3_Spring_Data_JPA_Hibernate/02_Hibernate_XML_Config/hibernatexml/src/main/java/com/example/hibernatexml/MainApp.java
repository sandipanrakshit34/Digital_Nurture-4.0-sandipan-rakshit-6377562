package com.example.hibernatexml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        // Create SessionFactory from hibernate.cfg.xml
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Get a new Session
        Session session = factory.openSession();

        try {
            // Begin transaction
            session.beginTransaction();

            // Create a new Student (DO NOT SET id)
            Student student = new Student("John", "Doe", "john.doe@example.com");

            // Save the Student object
            session.save(student);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Student saved with ID: " + student.getId());

        } finally {
            session.close();
            factory.close();
        }
    }
}
