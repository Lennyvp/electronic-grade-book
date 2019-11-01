package com.patryk_michal.electronicgradebook.springSecurityConfig.forTesting;

import com.patryk_michal.electronicgradebook.model.Admin;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class ControllerToTestEveryUserPermissions {

    //jak bedziemy konfigurowac Spring Security, to te metody beda widzalne w zaleznosci kto bedzie zalogowany
    //teraz mozne kazdy pod nie wbic

    @GetMapping("/headAdmin")
    public String onlyVisibleToHeadAdmin(){
        return "headAdmin";
    }

    @GetMapping("/admin")
    public String onlyVisibleToAdmin(){
        return "Admin";
    }

    @GetMapping("/teacher")
    public String onlyVisibleToTeacher(){
        return "Teacher";
    }

    @GetMapping("/parent")
    public String onlyVisibleToParent(){
        return "Parent";
    }

    @GetMapping("/student")
    public String onlyVisibleToStudent(){
        return "Student";
    }
}
