package com.patryk_michal.electronicgradebook.model;

import javax.persistence.Entity;

@Entity
public class Student extends Person {

    private String studentClass;

//    public Student(int ID, String login, String password, String name, String surname) {
//        super(ID, login, password, name, surname);
//        setROLE("STUDENT");
//    }

    public Student(int ID, String login, String password, String name, String surname, String studentClass) {
        super(ID, login, password, name, surname);
        this.studentClass = studentClass;
        setROLE("STUDENT");
    }

    public Student(String login, String password, String name, String surname, String studentClass) {
        super(login, password, name, surname);
        this.studentClass = studentClass;
        setROLE("STUDENT");
    }

    public Student() {
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }
}
