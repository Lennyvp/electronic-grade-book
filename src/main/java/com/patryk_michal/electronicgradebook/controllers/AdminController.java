package com.patryk_michal.electronicgradebook.controllers;

import com.patryk_michal.electronicgradebook.Model.Admin;
import com.patryk_michal.electronicgradebook.postgressConnection.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/allAdmins")
    public Iterable<Admin> allAdmins(){
        return adminRepository.findAll();
    }
}
