package com.hx.hibernate.model;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.Column;


public class test {
    private static SessionFactory sf = null;

    @BeforeClass
    public static void beforeClass() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        sf = cfg.buildSessionFactory(serviceRegistry);
    }

    @Test
    public void studentUpdate(){

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("update Student s set name='hexing' where id=1");
        q.executeUpdate();
        session.getTransaction().commit();

    }

    @Test
    public void studenttest(){
        Student student = new Student();
        student.setAge(11);
        student.setName("11");

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    @Test
    public void studentGet(){

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Student s = (Student) session.get(Student.class,1);
        System.out.println(s.getName());
        System.out.println(s.getClass());
        session.getTransaction().commit();
    }

    @Test
    public void studentLoad(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Student s = (Student) session.load(Student.class, 1);
        System.out.println(s.getName());
        System.out.println(s.getClass());
        session.getTransaction().commit();
    }

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