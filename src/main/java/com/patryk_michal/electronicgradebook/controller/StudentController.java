package com.patryk_michal.electronicgradebook.controller;

import com.patryk_michal.electronicgradebook.model.Grade;
import com.patryk_michal.electronicgradebook.model.Student;
import com.patryk_michal.electronicgradebook.postgressConnection.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/allStudents")
    public Iterable<Student> allStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/studentsInMyClass/{login}")
    public Iterable<Student> allStudents(@PathVariable String login){
        List<Student> studentsList = new ArrayList<>();

        Student StudentByLogin = studentRepository.findStudentByLogin(login);

        for (Student oneStudent : studentRepository.findAll()) {
            if (oneStudent.getStudentClass().equals(StudentByLogin.getStudentClass())) {
                studentsList.add(oneStudent);
            }
        }
        return studentsList;
    }
}
