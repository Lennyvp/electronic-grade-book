package com.patryk_michal.electronicgradebook.controllers;

import com.patryk_michal.electronicgradebook.Model.HeadAdmin;
import com.patryk_michal.electronicgradebook.postgressConnection.headAdmin.HeadAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeadAdminsController {

    @Autowired
    HeadAdminRepository headAdminRepository;

    @GetMapping("/allHeadAdmins")
    public Iterable<HeadAdmin> allHeadAdmins(){
        return headAdminRepository.findAll();
    }


}
