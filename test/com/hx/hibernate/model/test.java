package com.hx.hibernate.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class test {
    private static SessionFactory sf = null;
    @BeforeClass
    public static void beforeClass(){
        try {
            sf = new Configuration().configure().buildSessionFactory();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

//    @Test
//    public void studenttest(){
//        Student student = new Student();
//        student.setAge(11);
//        student.setName("11");
//
//        Session session = sf.openSession();
//        session.beginTransaction();
//        session.save(student);
//        session.getTransaction().commit();
//        session.close();
//    }

    @Test
    public void teachertest() {
        Teacher teacher = new Teacher();
        teacher.setName("22");
        teacher.setZhicheng(Zhicheng.b);

        Session session = sf.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }
    @AfterClass
    public static void afterClass(){
        sf.close();
    }
}