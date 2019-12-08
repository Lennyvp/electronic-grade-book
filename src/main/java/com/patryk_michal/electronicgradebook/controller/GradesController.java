package com.patryk_michal.electronicgradebook.controller;

import com.patryk_michal.electronicgradebook.additionalClasses.GradesAverage;
import com.patryk_michal.electronicgradebook.model.Grade;
import com.patryk_michal.electronicgradebook.model.Subject;
import com.patryk_michal.electronicgradebook.postgressConnection.grade.GradeRepository;
import com.patryk_michal.electronicgradebook.postgressConnection.schoolSubjects.SubjectRepository;
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

    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/allGrades")
    public Iterable<Grade> allGrades() {
        return gradeRepository.findAll();
    }

    @GetMapping("/gradeById/{id}")
    public Optional<Grade> gradeById(@PathVariable Long id) {
        return gradeRepository.findById(id);
    }

    @GetMapping("/studentGrades/{id}")
    public Iterable<Grade> studentGrades(@PathVariable Long id) {
        return getAllStudentGradesByStudentId(id);
    }

    @GetMapping("studentGradesByLogin/{login}")
    public Iterable<Grade> studentGrades(@PathVariable String login) {
        return getGradesByLogin(login);
    }

    //average with all Grades
    @GetMapping("/gradesAverageInSchool")
    public double allStudentGradesAverage() {
        return countAllGradesAverage();
    }

    //average from one subject in all school
    @GetMapping("/gradePointAverageFromSubject/{subject}")
    public double gradePointAverageFromSubject(@PathVariable String subject) {
        return countGradesAverage(subject);
    }

    //grades average in one class from all subjects
    @GetMapping("gradesAverageByClass/{myClass}")
    public double getGradesAverageInMyClass(@PathVariable String myClass) {
        return countGradesAverageInClass(myClass);
    }

    //grades Average By One Student From One Subject
    @GetMapping("gradesAverage/{studentLogin}/{subject}")
    public double getGradesAverageByOneStudentFromOneSubject(@PathVariable String studentLogin, @PathVariable String subject) {
        return countGradesAverageByOneStudentFromOneSubject(studentLogin,subject);
    }

    @GetMapping("gradesAverageListFromAllSubjects/{login}")
    public Iterable<GradesAverage> studentGradesList(@PathVariable String login){
        return getstudentGradesList(login);
    }

    private Iterable<GradesAverage> getstudentGradesList(String login){
        List<GradesAverage> gradesAverages = new ArrayList<>();
        for (Subject oneSubject: subjectRepository.findAll()){
            double averageFromSubject = countGradesAverageByOneStudentFromOneSubject(login,oneSubject.subjectName);
            gradesAverages.add(new GradesAverage(averageFromSubject,oneSubject.subjectName));
        }
        return gradesAverages;
    }

    private Iterable<Grade> getAllStudentGradesByStudentId(Long id){
        List<Grade> studentGradesList = new ArrayList<>();
        for (Grade oneGrade : gradeRepository.findAll()) {
            if (oneGrade.getStudent().getID() == id) {
                studentGradesList.add(oneGrade);
            }
        }
        return studentGradesList;
    }

    private Iterable<Grade> getGradesByLogin(String login){
        List<Grade> studentGradesList = new ArrayList<>();
        for (Grade oneGrade : gradeRepository.findAll()) {
            if (oneGrade.getStudent().getLogin().equals(login)) {
                studentGradesList.add(oneGrade);
            }
        }
        return studentGradesList;
    }

    private double countGradesAverage(String subjectName) {
        int counter = 0;
        double sum = 0;
        for (Grade oneGrade : gradeRepository.findAll()) {
            if (oneGrade.subject.subjectName.equals(subjectName)) {
                sum += oneGrade.grade;
                counter++;
            }
        }
        return sum / counter;
    }

    private double countGradesAverageInClass(String myClass){
        int counter = 0;
        double sum = 0;
        for (Grade oneGrade : gradeRepository.findAll()) {
            if (oneGrade.getStudent().getStudentClass().equals(myClass)) {
                sum += oneGrade.grade;
                counter++;
            }
        }
        return sum / counter;
    }

    private double countAllGradesAverage() {
        int counter = 0;
        double sum = 0;
        for (Grade oneGrade : gradeRepository.findAll()) {
            sum += oneGrade.grade;
            counter++;
        }
        return sum / counter;
    }

    private double countGradesAverageByOneStudentFromOneSubject(String studentLogin, String subject){
        int counter = 0;
        double sum = 0;
        for (Grade oneGrade : gradeRepository.findAll()) {
            if ((oneGrade.getStudent().getLogin().equals(studentLogin))&&(oneGrade.getSubject().subjectName.equals(subject))) {
                sum += oneGrade.grade;
                counter++;
            }
        }
        if(counter==0){
            return 0;
        }
        return sum / counter;
    }

}