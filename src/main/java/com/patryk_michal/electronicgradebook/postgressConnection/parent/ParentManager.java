package com.patryk_michal.electronicgradebook.postgressConnection.parent;

import com.patryk_michal.electronicgradebook.model.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ParentManager {
    @Autowired
    private  ParentRepository parentRepository;


    public void saveUser(Parent parent){
        parentRepository.save(parent);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveUser(new Parent(7,"Plogin","PPassword","Pname","Psurname"));
        saveUser(new Parent(8,"P2login","P2Password","P2name","P2surname"));
        saveUser(new Parent(9,"P3login","P3Password","P3name","P3surname"));
    }

}
