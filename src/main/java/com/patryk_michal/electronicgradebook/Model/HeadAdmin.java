package com.patryk_michal.electronicgradebook.Model;

import javax.persistence.Entity;

@Entity
public class HeadAdmin extends Person {

    public HeadAdmin(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
    }

    public HeadAdmin() {
    }
}
