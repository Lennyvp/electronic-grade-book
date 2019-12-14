package com.patryk_michal.electronicgradebook.postgressConnection.teacher;

import com.patryk_michal.electronicgradebook.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class TeacherManager {
    @Autowired
    private TeacherRepository teacherRepository;


    public void saveUser(Teacher teacher){
        teacherRepository.save(teacher);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveUser(new Teacher("Tlogin","TPassword","Tname","Tsurname","FEMALE"));
        saveUser(new Teacher("T2login","T2Password","T2name","T2surname","FEMALE"));
        saveUser(new Teacher("T3login","T3Password","T3name","T3surname","MALE"));
        saveUser(new Teacher("T4login","T4Password","T4name","T4surname","FEMALE"));
        saveUser(new Teacher("T5login","T5Password","T5name","T5surname","FEMALE"));
    }

}
