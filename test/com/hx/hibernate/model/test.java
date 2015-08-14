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

import java.util.Iterator;
import java.util.List;


public class test {
    private static SessionFactory sf = null;

    @BeforeClass
    public static void beforeClass() {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        sf = cfg.buildSessionFactory(serviceRegistry);
    }
    @Test
    public void insertBBs(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        for (int i = 1; i <= 10; i++){
            Bankuai b = new Bankuai();
            b.setName("b"+i);
            Topic t = new Topic();
            t.setBankuai(b);
            t.setTitle("t"+i);
            session.save(b);
            session.save(t);
        }
        session.getTransaction().commit();
    }

    @Test
    public void Hql(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Bankuai ");
        List<Bankuai> bankuais = query.list();
        for (Bankuai b:bankuais)
            System.out.println(b.getId()+"--"+b.getName());
        session.getTransaction().commit();
    }
    @Test
    public void Hql1(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Bankuai");
        Iterator<Bankuai> bankuaiIterator = query.iterate();
        while (bankuaiIterator.hasNext()){
            Bankuai b = bankuaiIterator.next();
            System.out.println(b.getId()+"--"+b.getName());
        }
//
        session.getTransaction().commit();
    }

    @Test
    public void insertOrg(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Org org = new Org();
        org.setName("总公司");
        Org org1 = new Org();
        org1.setName("分公司１");
        Org org2 = new Org();
        org2.setName("分公司２");
        Org org3 = new Org();
        org3.setName("分公司１－１");
        Org org4 = new Org();
        org4.setName("分公司１－２");
        org.getChildren().add(org1);
        org.getChildren().add(org2);
        org1.getChildren().add(org3);
        org1.getChildren().add(org4);
        org4.setParent(org1);
        org3.setParent(org1);
        org1.setParent(org);
        org2.setParent(org);
        session.save(org);
        session.getTransaction().commit();
    }
    @Test
    public void loadOrg(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        Org org = (Org) session.load(Org.class,1);
        print(org);
        session.getTransaction().commit();
    }

    private void print(Org org) {
        System.out.println(org.getName());
        for (Org child:org.getChildren())
            print(child);
    }

    @Test
    public void InsertUser(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        G g = new G();
        g.setName("aaa");
        User user = new User();
        user.setName("bbb");
        user.setGroup(g);
        User user1 = new User();
        user1.setName("ccc");
        user1.setGroup(g);
        session.save(user);
        session.save(user1);
        session.getTransaction().commit();
    }
    @Test
    public void updateUser(){
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        G g = (G) session.load(G.class,1);
//        session.delete(g);
        session.getTransaction().commit();
    }

    @Test
    public void studentUpdate(){

        Session session = sf.getCurrentSession();
        session.beginTransaction();
        session.getTransaction().commit();

    }

    @Test
    public void studenttest(){
        Student student = new Student();
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