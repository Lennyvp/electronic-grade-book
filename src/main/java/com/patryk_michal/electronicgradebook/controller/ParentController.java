package com.patryk_michal.electronicgradebook.controller;

import com.patryk_michal.electronicgradebook.model.Parent;
import com.patryk_michal.electronicgradebook.postgressConnection.parent.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    @Autowired
    ParentRepository parentRepository;

    @GetMapping("/allParents")
    public Iterable<Parent> allParents(){
        return parentRepository.findAll();
    }

}
