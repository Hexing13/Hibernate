package com.hx.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexing on 15-8-11.
 */
@Entity(name = "t_group")
public class Group {
    private int id;
    private String name;
    private Set<User> users = new HashSet<User>();

    @OneToMany(mappedBy = "group")
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
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
