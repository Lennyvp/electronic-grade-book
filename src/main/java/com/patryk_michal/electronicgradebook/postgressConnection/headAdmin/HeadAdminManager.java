package com.patryk_michal.electronicgradebook.postgressConnection.headAdmin;

import com.patryk_michal.electronicgradebook.Model.HeadAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class HeadAdminManager {
    @Autowired
    private HeadAdminRepository headAdminRepository;


    public void saveUser(HeadAdmin headAdmin){
        headAdminRepository.save(headAdmin);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveUser(new HeadAdmin(4,"Hlogin","HPassword","Hname","Hsurname"));
        saveUser(new HeadAdmin(5,"H2login","H2Password","H2name","H2surname"));
        saveUser(new HeadAdmin(6,"H3login","H3Password","H3name","H3surname"));
    }
}
