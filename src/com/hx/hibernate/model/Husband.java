package com.hx.hibernate.model;

import javax.persistence.*;

/**
 * Created by hexing on 15-8-8.
 */
@Entity
public class Husband {
    private int id;
    private String name;
    private Wife wife;

    @OneToOne
    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

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
}


