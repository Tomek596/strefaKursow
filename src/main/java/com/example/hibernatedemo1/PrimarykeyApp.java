package com.example.hibernatedemo1;

import com.example.hibernatedemo1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimarykeyApp {

    public static void main(String[] args) {

        //stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //wczytanie pliku konfiguracyjnego
        conf.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        conf.addAnnotatedClass(Employee.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //pobranie sesji
        Session session = factory.getCurrentSession();
        //stworzenie obiektu
        Employee employee = new Employee();
        employee.setFirstName("Krzysztof");
        employee.setLastName("Nowak");
        employee.setSalary(10000);

        Employee employee1 = new Employee();
        employee1.setFirstName("Janina");
        employee1.setLastName("Kowalska");
        employee1.setSalary(10000);

        Employee employee2 = new Employee();
        employee2.setFirstName("Andrzej");
        employee2.setLastName("Sienkiewicz");
        employee2.setSalary(10000);

        //rozpoczecie transakcji
        session.beginTransaction();
        //zapisanie 3 pracownika
        session.save(employee);
        session.save(employee1);
        session.save(employee2);
        //zakoncznie transackcji
        session.getTransaction().commit();
        //zamknircie obiektu SessionFactory
        factory.close();
    }
}
