package com.patryk_michal.electronicgradebook.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {

    public Admin(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
    }

    public Admin() {
    }
}
