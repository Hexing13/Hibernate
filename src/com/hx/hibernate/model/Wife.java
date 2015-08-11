package com.hx.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by hexing on 15-8-8.
 */
public class Wife {

    public String getWifename() {
        return wifename;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename;
    }

    private String wifename;


}
