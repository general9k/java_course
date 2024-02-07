package ru.rodionov.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.rodionov.example.model_one_to_many.Director;
import ru.rodionov.example.model_one_to_many.Movie;
import ru.rodionov.example.model_one_to_one.Principal;
import ru.rodionov.example.model_one_to_one.School;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // (HM2)
            // №1
//            School school = session.get(School.class, 2);
//            Principal principal = school.getPrincipal();
//            System.out.println(principal);

            // №2
//            Principal principal = new Principal("HM Test", 50);
//            School school = new School(88);
//            principal.setSchool(school);
//
//            session.save(principal);
            // №3
//            Principal principal = new Principal("TEST PRINCIPAL", 20);
//
//            session.save(principal);
//            School school = session.get(School.class, 2);
//            Principal principal = session.get(Principal.class, 7);
//            school.setPrincipal(principal);

            // №4
//            Principal principal = session.get(Principal.class, 7);
//            School school = session.get(School.class, 3);
//            school.setPrincipal(principal);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
