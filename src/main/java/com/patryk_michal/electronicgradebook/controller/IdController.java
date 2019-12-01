package com.patryk_michal.electronicgradebook.controller;

import com.patryk_michal.electronicgradebook.model.Student;
import com.patryk_michal.electronicgradebook.postgressConnection.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdController {
    //zwraca id "zalogowanego" studenta
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/StudentId/{login}")
    public Student gradeById(@PathVariable String login) {
        return studentRepository.findStudentByLogin(login);
    }

}
