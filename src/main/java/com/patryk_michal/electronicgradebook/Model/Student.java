package com.patryk_michal.electronicgradebook.Model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    public Student(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
    }

    public Student(String login, String password, String name, String surname) {
        super(login, password, name, surname);
    }
}
