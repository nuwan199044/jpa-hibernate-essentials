package org.myapp;

import org.myapp.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Kamal");
        Employee e2 = new Employee(2, "Sarath");
        Employee e3 = new Employee(3, "Kosala");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeeApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(e1);
        entityManager.persist(e2);
        entityManager.persist(e3);
        transaction.commit();
    }
}