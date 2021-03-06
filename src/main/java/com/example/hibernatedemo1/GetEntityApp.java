package com.example.hibernatedemo1;

import com.example.hibernatedemo1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetEntityApp {

    public static void main(String[] args) {
        //stworzenie pliku konfiguracyjnego
        Configuration configuration = new Configuration();
        //wczytanie pliku konfiguracyjnego
        configuration.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        configuration.addAnnotatedClass(Employee.class);
        //stworzenie obiektu SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //pobranie sesji
        Session session = sessionFactory.getCurrentSession();
        //stworznie obiektu
        Employee employee = new Employee();
        employee.setFirstName("Tadeusz");
        employee.setLastName("Wiśniewski");
        employee.setSalary(10000);
        //rozpoczecie transakcji
        session.beginTransaction();
        //zapisanie pracownika
        Integer id = (Integer) session.save(employee);
        session.getTransaction().commit();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Employee retrivedEmployee = session.get(Employee.class, id);
        session.getTransaction().commit();
        System.out.println("Dane pracownika " + retrivedEmployee.toString());

        //zamkniecie obiektu sessionFactory
        sessionFactory.close();

    }
}
