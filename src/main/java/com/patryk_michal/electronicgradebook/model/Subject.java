package com.patryk_michal.electronicgradebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subject {

    @Id
    @GeneratedValue
    private int ID;
    public String subjectName;

    public Subject() {
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
