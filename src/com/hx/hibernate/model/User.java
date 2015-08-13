package com.hx.hibernate.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by hexing on 15-8-11.
 */
@Entity
public class User {
    private int id;
    private String name;
    private G group;

    @ManyToOne
    @Cascade(CascadeType.ALL)
    public G getGroup() {
        return group;
    }
    public void setGroup(G group) {
        this.group = group;
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
