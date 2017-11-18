package org.medservice.controllers;

import com.mongodb.gridfs.GridFSDBFile;
import org.medservice.models.Patient;
import org.medservice.services.FileImageServiceImpl;
import org.medservice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
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
    public String addPatient(@RequestParam(value = "file") MultipartFile file,
                              Patient patient, Principal principal) {
        String fileName = file.getOriginalFilename();
        patient.setDoctorLogin(principal.getName());
        patient.setFileName(fileName);
        fileImageService.saveFile(file, fileName);
        patientService.save(patient);
        return "redirect:patients_table";
    }

    @GetMapping("/update_patient/{id}")
    public String updatePatient(@PathVariable("id") String patientId, Model model) {
        model.addAttribute("patient", patientService.findById(Long.parseLong(patientId)));
        return "update_patient";
    }

    @PostMapping("/update_patient")
    public String updatePatient(@RequestParam(value = "file") MultipartFile file, Patient patient) {
        if (!fileImageService.isPresentFile(file.getOriginalFilename()) && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            fileImageService.saveFile(file, fileName);
            patient.setFileName(fileName);
        }
        if (file.isEmpty()) {
            patient.setFileName(patientService.findById(patient.getId()).getFileName());
        }
        patientService.update(patient);
        return "redirect:patients_table";
    }

    @GetMapping("/patient_info/{id}")
    public String getPatient(@PathVariable("id") String patientId, Model model) {
        model.addAttribute("patient", patientService.findById(Long.parseLong(patientId)));
        return "patient_info";
    }

    @GetMapping("/roentgen/{id:.+}")
    public ResponseEntity<InputStreamResource> getRoentgenImage(@PathVariable("id") String reference) {
        GridFSDBFile image = fileImageService.getFileName(reference);
        return ResponseEntity.ok()
                .contentLength(image.getLength())
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .body(new InputStreamResource(image.getInputStream()));
    }
}
