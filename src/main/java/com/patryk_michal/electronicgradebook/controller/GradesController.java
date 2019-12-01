package com.patryk_michal.electronicgradebook.controller;

import com.patryk_michal.electronicgradebook.model.Grade;
import com.patryk_michal.electronicgradebook.postgressConnection.grade.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GradesController {

    @Autowired
    GradeRepository gradeRepository;

    @GetMapping("/allGrades")
    public Iterable<Grade> allGrades(){
        return gradeRepository.findAll();
    }

    @GetMapping("/gradeById/{id}")
    public Optional<Grade> gradeById(@PathVariable Long id) {
        return gradeRepository.findById(id);
    }

    @GetMapping("/studentGrades/{id}")
    public Iterable<Grade> studentGrades(@PathVariable Long id) {
        List<Grade> studentGradesList = new ArrayList<>();
        for(Grade oneGrade:gradeRepository.findAll()){
            if(oneGrade.getStudent().getID()==id){
                studentGradesList.add(oneGrade);
            }
        }
        return studentGradesList;
    }

    @GetMapping("studentGradesByLogin/{login}")
    public Iterable<Grade> studentGrades(@PathVariable String login){
        List<Grade> studentGradesList = new ArrayList<>();
        for(Grade oneGrade:gradeRepository.findAll()){
            if(oneGrade.getStudent().getLogin().equals(login)){
                studentGradesList.add(oneGrade);
            }
        }
        return studentGradesList;
    }

    }

