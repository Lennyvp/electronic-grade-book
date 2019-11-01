package com.patryk_michal.electronicgradebook.springSecurityConfig.forTesting;

import com.patryk_michal.electronicgradebook.Model.*;
import org.springframework.stereotype.Service;

@Service
public class SomeTestModels {

    private HeadAdmin headAdmin;
    private Admin admin;
    private Teacher teacher;
    private Parent parent;
    private Student student;

    public SomeTestModels() {
        headAdmin = new HeadAdmin(1,"headAdmin","headAdminPassword","nameHeadAdmin","surnameHeadAdmin");
        admin = new Admin(2,"admin","adminPassword","nameAdmin","surnameAdmin");
        teacher = new Teacher(3,"teacher","teacherPassword","nameTeacher","surnameTeacher");
        parent = new Parent(4,"parent","parentPassword","nameParent","surnameParent");
        student = new Student(5,"student","studentPassword","nameStudent","surnameStudent");
    }

    public HeadAdmin getHeadAdmin() {
        return headAdmin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Parent getParent() {
        return parent;
    }

    public Student getStudent() {
        return student;
    }
}
