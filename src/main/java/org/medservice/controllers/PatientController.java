package org.medservice.controllers;

import com.mongodb.gridfs.GridFSDBFile;
import org.medservice.models.Patient;
import org.medservice.services.FileImageServiceImpl;
import org.medservice.services.PatientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class PatientController {

    public static final Logger logger = LoggerFactory.getLogger("PatientController");

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
    public String addPatient(@RequestParam(value = "file") MultipartFile[] files,
                             Patient patient, Principal principal) {
        ArrayList<String> nameFiles = new ArrayList<>();
        patient.setDoctorLogin(principal.getName());
        Arrays.stream(files).forEach(file -> {
            String fileName = file.getOriginalFilename();
            nameFiles.add(fileName);
            fileImageService.saveFile(file, fileName);
        });
        patient.setListFileNames(nameFiles);
        patientService.save(patient);
        logger.info("doctor {} added new patient: {} {}", patient.getDoctorLogin(),
                patient.getName(), patient.getLastName());
        return "redirect:patients_table";
    }

    @GetMapping("/update_patient/{id}")
    public String updatePatient(@PathVariable("id") String patientId, Model model) {
        model.addAttribute("patient", patientService.findById(Long.parseLong(patientId)));
        return "update_patient";
    }

    @PostMapping("/update_patient")
    public String updatePatient(@RequestParam(value = "file") MultipartFile[] files,
                                @RequestParam(value = "flagSave", required = false) String[] flags,
                                Patient patient) {
        ArrayList<String> listNameFiles = patientService.findById(patient.getId()).getListFileNames();
        if (flags != null) {
            Arrays.stream(flags).forEach(i -> {
                listNameFiles.remove(Integer.parseInt(i));
            });
            listNameFiles.trimToSize();
            patient.setListFileNames(listNameFiles);
        }

        if (files == null) {
            patient.setListFileNames(listNameFiles);
        } else {
            ArrayList<String> listName = new ArrayList<>();
            if (listNameFiles != null) {
                listName.addAll(listNameFiles);
            }
            Arrays.stream(files).forEach(file -> {
                String fileName = file.getOriginalFilename();
                listName.add(fileName);
                fileImageService.saveFile(file, fileName);
            });
            patient.setListFileNames(listName);
        }
        patientService.update(patient);
        logger.info("doctor {} change patient: {} {}", patient.getDoctorLogin(),
                patient.getName(), patient.getLastName());
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
