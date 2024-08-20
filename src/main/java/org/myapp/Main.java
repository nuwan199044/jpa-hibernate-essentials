package org.myapp;

import org.myapp.entity.AccessCard;
import org.myapp.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Create
        createEmployee();

        //Read
//        fetchEmployee();

        //update
//        updateEmployee();

        //delete
//        deleteEmployee();

    }

    private static EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeeApp");
        return entityManagerFactory.createEntityManager();
    }

    private static void createEmployee() {
        Employee e1 = Employee.builder().name("Kamal").build();
        Employee e2 = Employee.builder().name("Sarath").build();
        Employee e3 = Employee.builder().name("Kosala").build();

        AccessCard a1 = AccessCard.builder().issueDate(new Date()).isActive(true).firmwareVersion("1.0.0").build();
        AccessCard a2 = AccessCard.builder().issueDate(new Date()).isActive(true).firmwareVersion("1.0.1").build();
        AccessCard a3 = AccessCard.builder().issueDate(new Date()).isActive(false).firmwareVersion("1.0.2").build();

        e1.setAccessCard(a1);
        e2.setAccessCard(a2);
        e3.setAccessCard(a3);

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

    private static void deleteEmployee() {
        EntityManager entityManager = getEntityManager();
        Employee e1 = entityManager.find(Employee.class, 1);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(e1);
        transaction.commit();
        entityManager.close();
    }

}