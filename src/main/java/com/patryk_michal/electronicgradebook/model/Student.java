package com.patryk_michal.electronicgradebook.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    public Student(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
        setROLE("STUDENT");
    }

    public Student() {
    }
}
