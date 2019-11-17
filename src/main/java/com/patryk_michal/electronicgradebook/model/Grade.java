package com.patryk_michal.electronicgradebook.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private int ID;

    public int grade;

    public LocalDateTime dateOfIssue;

    @ManyToOne
    public Student student;

    public Grade() {
    }

    public Grade(int grade, LocalDateTime dateOfIssue, Student student) {
        this.grade = grade;
        this.dateOfIssue = dateOfIssue;
        this.student = student;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDateTime dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
