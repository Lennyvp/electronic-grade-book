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
        saveUser(new Teacher(13,"Tlogin","TPassword","Tname","Tsurname"));
        saveUser(new Teacher(14,"T2login","T2Password","T2name","T2surname"));
        saveUser(new Teacher(15,"T3login","T3Password","T3name","T3surname"));
    }

}
