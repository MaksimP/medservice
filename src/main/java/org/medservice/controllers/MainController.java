package org.medservice.controllers;


import org.medservice.models.Doctor;
import org.medservice.repository.DoctorRepository;
import org.medservice.repository.PatientRepository;
import org.medservice.services.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private DoctorServiceImpl doctorService;


    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/")
    public String home(Model model) {
        return "welcome";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    /*@PostMapping("/login")
    public String login() {
        return "redirect:add_doctor";
    }*/

    @GetMapping("/department")
    public String department(Model model) {
        return "department";
    }

    @GetMapping("/add_doctor")
    public String addDoctor(Model model) {
        return "add_doctor";
    }

    @PostMapping("/add_doctor")
    public String addDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "add_doctor";
    }

    @GetMapping("/doctors_table")
    public String getDoctors(Model model) {
        return "doctors_table";
    }

    @GetMapping("/patients_table")
    public String getPatients(Model model) {
        return "patients_table";
    }
}



