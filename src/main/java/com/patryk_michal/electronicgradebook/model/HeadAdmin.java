package com.patryk_michal.electronicgradebook.model;

import javax.persistence.Entity;

@Entity
public class HeadAdmin extends Person {

    public HeadAdmin(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
        setROLE("HEAD_ADMIN");
    }

    public HeadAdmin() {
    }
}
