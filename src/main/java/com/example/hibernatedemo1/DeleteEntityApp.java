package com.example.hibernatedemo1;

import com.example.hibernatedemo1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEntityApp {
    public static void main(String[] args) {
        //stworzenie pliku konfiguracyjnego
        Configuration configuration = new Configuration();
        //wczytanie pliku konfiguracyjnego
        configuration.configure("hibernate.cfg.xml");
        //wczytanie adnotacji
        configuration.addAnnotatedClass(Employee.class);
        //stworzenie obiektu SessionFactory
        SessionFactory factory = configuration.buildSessionFactory();
        //pobranie sesji
        Session session = factory.getCurrentSession();
        //rozpoczecie transakcji
        session.beginTransaction();
        Employee employee = session.get(Employee.class, 9);

        session.delete(employee);
        session.getTransaction().commit();

        //zamkniecie obiektu sessionFactory
        factory.close();
    }
}
