package com.patryk_michal.electronicgradebook.postgressConnection.student;

import com.patryk_michal.electronicgradebook.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class StudentManager {

    @Autowired
    private StudentRepository studentRepository;


    public void saveUser(Student student){
        studentRepository.save(student);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveUser(new Student(10,"Slogin","SPassword","Sname","Ssurname"));
        saveUser(new Student(11,"S2login","S2Password","S2name","S2surname"));
        saveUser(new Student(12,"S3login","S3Password","S3name","S3surname"));
    }

}
