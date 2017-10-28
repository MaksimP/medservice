package org.medservice.controllers;


import org.medservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/admin")
    public String admin(Model model) {
        
        return "admin";
    }

    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/department")
    public String department(Model model) {
        return "department";
    }
}



