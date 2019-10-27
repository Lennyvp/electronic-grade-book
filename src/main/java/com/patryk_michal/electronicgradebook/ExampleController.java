package com.patryk_michal.electronicgradebook;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping()
    public String wyswietl(){
        return "proba";
    }

}
