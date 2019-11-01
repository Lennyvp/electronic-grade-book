package com.patryk_michal.electronicgradebook.controllers;

import com.patryk_michal.electronicgradebook.Model.Teacher;
import com.patryk_michal.electronicgradebook.postgressConnection.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/allTeachers")
    public Iterable<Teacher> allTeachers(){
        return teacherRepository.findAll();
    }
}
