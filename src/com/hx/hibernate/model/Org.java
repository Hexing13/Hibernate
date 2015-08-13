package com.hx.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexing on 15-8-13.
 */
@Entity
public class Org {
    private int id;
    private String name;
    private Set<Org> children = new HashSet<Org>();
    private Org parent;

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

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Org> getChildren() {
        return children;
    }

    public void setChildren(Set<Org> children) {
        this.children = children;
    }

    @ManyToOne
    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }
}
