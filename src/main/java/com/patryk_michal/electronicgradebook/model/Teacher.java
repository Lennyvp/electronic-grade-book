package com.patryk_michal.electronicgradebook.model;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {

    public Teacher(String login, String password, String name, String surname, String SEX) {
        super(login, password, name, surname, SEX);
        setROLE("TEACHER");
    }

    public Teacher(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
        setROLE("TEACHER");
    }

    public Teacher() {
    }
}
