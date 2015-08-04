package com.hx.client;

import com.hx.hibernate.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by hexing on 15-8-4.
 */
public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("hexing");
        teacher.setId(1);
        teacher.setTitle("高级");

        Configuration c = new AnnotationConfiguration();
        SessionFactory s = c.configure().buildSessionFactory();
        Session session = s.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
        s.close();
    }
}
