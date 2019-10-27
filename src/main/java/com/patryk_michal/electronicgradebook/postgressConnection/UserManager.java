package com.patryk_michal.electronicgradebook.postgressConnection;

import com.patryk_michal.electronicgradebook.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    @Autowired
    private ExampleUserRepository exampleUserRepository;


    public void saveUser(Student student){
        exampleUserRepository.save(student);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveUser(new Student("Ulogin","UPassword","Uname","Usurname"));
    }

}
