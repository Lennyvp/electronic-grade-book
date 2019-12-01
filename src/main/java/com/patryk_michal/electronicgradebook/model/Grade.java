package com.patryk_michal.electronicgradebook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Grade {

    @Id
    @GeneratedValue
    private int ID;

    public int grade;

    public LocalDateTime dateOfIssue;

    @ManyToOne
    public Student student;

    @ManyToOne
    public Subject subject;

    public Grade() {
    }

    public Grade(int grade, LocalDateTime dateOfIssue, Student student, Subject subject) {
        this.grade = grade;
        this.dateOfIssue = dateOfIssue;
        this.student = student;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
