package com.patryk_michal.electronicgradebook.postgressConnection.admin;

import com.patryk_michal.electronicgradebook.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AdminManager {

    @Autowired
    private AdminRepository adminRepository;


    public void saveUser(Admin admin){
        adminRepository.save(admin);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveUser(new Admin(1,"Alogin","APassword","Aname","Asurname"));
        saveUser(new Admin(2,"A2login","A2Password","A2name","A2surname"));
        saveUser(new Admin(3,"A3login","A3Password","A3name","A3surname"));
    }

}
