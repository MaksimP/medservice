package org.medservice.controllers;


import org.medservice.models.Doctor;
import org.medservice.models.Patient;
import org.medservice.repository.DoctorRepository;
import org.medservice.repository.PatientRepository;
import org.medservice.services.DoctorServiceImpl;
import org.medservice.services.PatientServiceImpl;
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

    @Autowired
    private PatientServiceImpl patientService;


    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/department")
    public String department(Model model) {
        return "department";
    }

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



