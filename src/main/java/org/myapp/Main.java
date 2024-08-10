package org.myapp;

import org.myapp.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Employee e1 = Employee.builder().id(1).name("Kamal").build();
        Employee e2 = Employee.builder().id(2).name("Sarath").build();
        Employee e3 = Employee.builder().id(3).name("Kosala").build();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeeApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(e1);
        entityManager.persist(e2);
        entityManager.persist(e3);
        transaction.commit();

        //Data Fetching
        Employee employee1 = entityManager.find(Employee.class, 1);
        Employee employee2 = entityManager.find(Employee.class, 2);
        System.out.println("Employee 1 "+employee1);
        System.out.println("Employee 2 "+employee2);
    }
}