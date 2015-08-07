package com.hx.hibernate.model;

import javax.persistence.*;

/**
 * Created by hexing on 15-8-7.
 */
enum Zhicheng{a,b,c}

@Entity
public class Teacher {
    private int id;
    private String name;
    private Zhicheng zhicheng;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public Zhicheng getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(Zhicheng zhicheng) {
        this.zhicheng = zhicheng;
    }
}
