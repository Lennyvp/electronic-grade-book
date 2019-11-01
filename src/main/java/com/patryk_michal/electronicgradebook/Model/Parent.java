package com.patryk_michal.electronicgradebook.Model;

import javax.persistence.Entity;

@Entity
public class Parent extends Person {

    public Parent(int ID, String login, String password, String name, String surname) {
        super(ID, login, password, name, surname);
        setROLE("PARENT");
    }

    public Parent() {
    }
}
