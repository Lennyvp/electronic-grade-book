package com.patryk_michal.electronicgradebook.Model;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {

    public Teacher(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
    }
}
