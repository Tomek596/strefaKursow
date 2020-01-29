package com.example.hibernatedemo1;

import com.example.hibernatedemo1.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetAllEntitiesApp {
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
        //rozpoczecie transakcji
        session.beginTransaction();

        List<Employee> resultList = session.createQuery("from Employee").getResultList();

        for (Employee employee: resultList) {
            System.out.println(employee);
        }


        //zakonczenie transakcji
        session.getTransaction().commit();
        //zamkniecie obiektu SessionFactory
        factory.close();

    }
}
