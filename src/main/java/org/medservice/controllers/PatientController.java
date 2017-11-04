package org.medservice.controllers;

import org.medservice.models.Patient;
import org.medservice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping("/patients_table")
    public String getPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients_table";
    }

    @GetMapping("/add_patient")
    public String addPatients(Model model) {
        return "add_patient";
    }

    @PostMapping("/add_patient")
    public String addPatients(Patient patient) {
        patientService.save(patient);
        return "redirect:patients_table";
    }
}
