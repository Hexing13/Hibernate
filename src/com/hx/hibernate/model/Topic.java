package com.hx.hibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hexing on 15-8-13.
 */
@Entity
public class Topic {
    private int id;
    private String title;
    private Bankuai bankuai;
    private Set<Msg> msgs = new HashSet<Msg>();

    @OneToMany(mappedBy = "topic")
    public Set<Msg> getMsgs() {
        return msgs;
    }

    public void setMsgs(Set<Msg> msgs) {
        this.msgs = msgs;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    public Bankuai getBankuai() {
        return bankuai;
    }

    public void setBankuai(Bankuai bankuai) {
        this.bankuai = bankuai;
    }
}
