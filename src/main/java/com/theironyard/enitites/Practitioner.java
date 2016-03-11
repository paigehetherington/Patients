package com.theironyard.enitites;

import com.sun.org.glassfish.gmbal.ManagedObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by vajrayogini on 3/10/16.
 */
@Entity
public class Practitioner {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String userName;
    @Column(nullable = false)
    String password;

    public Practitioner(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getPasswordHash() {
        return password;
    }

    public Practitioner() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
