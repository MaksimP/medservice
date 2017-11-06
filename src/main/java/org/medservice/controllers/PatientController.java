package org.medservice.controllers;

import org.medservice.models.Patient;
import org.medservice.services.FileImageServiceImpl;
import org.medservice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping(value = "/")
public class PatientController {

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private FileImageServiceImpl fileImageService;

    @GetMapping("/patients_table")
    public String getPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients_table";
    }

    @GetMapping("/add_patient")
    public String addPatients() {
        return "add_patient";
    }

    @PostMapping("/add_patient")
    public String addPatients(@RequestParam(value = "file") MultipartFile file,
                              Patient patient, Principal principal) {
        patient.setDoctorLogin(principal.getName());
        fileImageService.saveFile(file);
        patientService.save(patient);
        return "redirect:patients_table";
    }

    @GetMapping("/patient_info/{id}")
    public String getPatient(@PathVariable("id") String patientId, Model model) {
        //model.addAttribute("patient", patientService.findById(1L));
        System.out.println(patientId);
        model.addAttribute("patient", patientService.findById(Long.parseLong(patientId)));
        return "patient_info";
    }
}
