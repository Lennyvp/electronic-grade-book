package com.patryk_michal.electronicgradebook.controllers;

import com.patryk_michal.electronicgradebook.Model.Student;
import com.patryk_michal.electronicgradebook.postgressConnection.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/allStudents")
    public Iterable<Student> allStudents(){
        return studentRepository.findAll();
    }

}
