package com.patryk_michal.electronicgradebook.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue
    private int ID;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String SEX;
    private String ROLE;

    public Person(String login, String password, String name, String surname, String SEX) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.SEX = SEX;
    }

    public Person(int ID, String login, String password, String name, String surname) {
        this.ID = ID;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Person(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }
}
