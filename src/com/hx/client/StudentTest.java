package com.hx.client;

import com.hx.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by hexing on 15-8-3.
 */

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId("a");
        student.setAge(22);
        student.setName("hexing2");

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}


