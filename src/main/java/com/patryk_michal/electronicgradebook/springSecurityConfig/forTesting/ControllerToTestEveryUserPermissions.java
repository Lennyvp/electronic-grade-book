package com.patryk_michal.electronicgradebook.springSecurityConfig.forTesting;

import com.patryk_michal.electronicgradebook.model.Admin;
import com.patryk_michal.electronicgradebook.model.Student;
import com.patryk_michal.electronicgradebook.postgressConnection.student.StudentRepository;
import com.patryk_michal.electronicgradebook.postgressConnection.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class ControllerToTestEveryUserPermissions {

    //jak bedziemy konfigurowac Spring Security, to te metody beda widzalne w zaleznosci kto bedzie zalogowany
    //teraz mozne kazdy pod nie wbic

    @Autowired
    StudentRepository studentRepository;
//    @Autowired
//    TeacherRepository teacherRepository;
    @Autowired
    SomeTestModels someTestModels;

    @GetMapping("/headAdmin")
    public String onlyVisibleToHeadAdmin(){
        return "headAdmin";
    }

    @GetMapping("/admin")
    public String onlyVisibleToAdmin(){
        return "Admin";
    }

    @GetMapping("/teacher")
    public String onlyVisibleToTeacher(){
        return "Teacher";
    }

    @GetMapping("/parent")
    public String onlyVisibleToParent(){
        return "Parent";
    }

    @GetMapping("/student")
    public Iterable<Student> onlyVisibleToStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/studentsforEveryone")
    public Iterable<Student> allStudents(){
        return studentRepository.findAll();
    }



}
