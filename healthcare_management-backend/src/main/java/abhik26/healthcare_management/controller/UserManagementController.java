package abhik26.healthcare_management.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abhik26.healthcare_management.entity.User;
import abhik26.healthcare_management.service.UserManagementServiceImpl;



@RestController
public class UserManagementController {

    @Autowired
    private UserManagementServiceImpl userManagementService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody User user) {
        userManagementService.registerUser(user);
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Welcome to 'Healthcare Management'!";
    }
    
}
