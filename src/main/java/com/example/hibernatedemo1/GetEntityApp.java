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



    }
}
