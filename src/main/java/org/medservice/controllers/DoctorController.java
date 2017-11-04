package org.medservice.controllers;


import org.medservice.models.Doctor;
import org.medservice.services.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl doctorService;

    @GetMapping("/doctors_table")
    public String getDoctors(Model model) {
        model.addAttribute("doctors", doctorService.findAll());
        return "doctors_table";
    }

    @GetMapping("/add_doctor")
    public String addDoctor(Model model) {
        return "add_doctor";
    }

    @PostMapping("/add_doctor")
    public String addDoctor(Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:doctors_table";
    }
}
