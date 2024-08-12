package org.myapp;

import org.myapp.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //Create
        createEmployee();

        //Read
        fetchEmployee();

        //update
        updateEmployee();

    }

    private static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeeApp");
        return entityManagerFactory.createEntityManager();
    }

    private static void createEmployee() {
        Employee e1 = Employee.builder().id(1).name("Kamal").build();
        Employee e2 = Employee.builder().id(2).name("Sarath").build();
        Employee e3 = Employee.builder().id(3).name("Kosala").build();
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(e1);
        entityManager.persist(e2);
        entityManager.persist(e3);
        transaction.commit();
        entityManager.close();
    }

    private static void fetchEmployee() {
        EntityManager entityManager = getEntityManager();
        Employee employee1 = entityManager.find(Employee.class, 1);
        Employee employee2 = entityManager.find(Employee.class, 2);
        System.out.println("Employee 1 "+employee1);
        System.out.println("Employee 2 "+employee2);
        entityManager.close();
    }

    private static void updateEmployee() {
        EntityManager entityManager = getEntityManager();
        Employee e1 = entityManager.find(Employee.class, 1);
        EntityTransaction transaction = entityManager.getTransaction();
        e1.setName("Nuwan");
        transaction.begin();
        entityManager.persist(e1);
        transaction.commit();
        entityManager.close();
    }

}