package org.medservice.controllers;

import com.mongodb.gridfs.GridFSDBFile;
import org.medservice.converters.FileImageConverter;
import org.medservice.models.BlobFileXRay;
import org.medservice.models.Patient;
import org.medservice.services.FileImageServiceImpl;
import org.medservice.services.FileXRayServiceImpl;
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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger("PatientController");

    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private FileXRayServiceImpl fileXRayService;

    @GetMapping("/patients_table")
    public String getPatients(Model model) {
        model.addAttribute("patients", patientService.findAll());
        return "patients_table";
    }

    @GetMapping("/add_patient")
    public String addPatient() {
        return "add_patient";
    }

    @PostMapping("/add_patient")
    public String addPatient(@RequestParam(value = "file") MultipartFile[] files,
                             @RequestParam(value = "dateXRay", required = false) String[] dateXRay,
                             @RequestParam(value = "descriptionXRay", required = false)String[] descriptionXRay,
                             Patient patient, Principal principal) {
        if (!files[0].isEmpty()) {
            patient.setArrayBlobFileXRay(fileXRayService.createListBlob(files, dateXRay, descriptionXRay));
        }
        patient.setDoctorLogin(principal.getName());
        patientService.save(patient);

        logger.info("doctor {} added new patient: {} {}", patient.getDoctorLogin(),
                patient.getName(), patient.getLastName());

        return "redirect:patients_table";
    }

    @GetMapping("/update_patient/{id}")
    public String updatePatient(@PathVariable("id") String patientId, Model model, Principal principal) {
        long id = Long.parseLong(patientId);
        Patient patient = patientService.findById(id);
        String currentUser = principal.getName();
        if (currentUser.equals(patient.getDoctorLogin())
                || currentUser.equals("admin")) {
            model.addAttribute("patient", patient);
            return "update_patient";
        } else {
            return "403";
        }
    }

    @PostMapping("/update_patient")
    public String updatePatient(@RequestParam(value = "file") MultipartFile[] files,
                                @RequestParam(value = "dateXRay", required = false) String[] dateXRay,
                                @RequestParam(value = "descriptionXRay", required = false)String[] descriptionXRay,
                                @RequestParam(value = "flagSave", required = false) String[] flagsSave,
                                @RequestParam(value = "flagChange", required = false) String[] flagsChange,
                                @RequestParam(value = "dateXRayEdit", required = false) String[] dateXRayEdit,
                                @RequestParam(value = "descriptionXRayEdit", required = false) String[] descriptionXRayEdit,
                                Patient patient, Principal principal) {
        ArrayList<BlobFileXRay> blobFileXRayArrayList = patientService.findById(patient.getId()).getArrayBlobFileXRay();        ;
        patient.setArrayBlobFileXRay(fileXRayService.updateListBlob(files, dateXRay, descriptionXRay, flagsSave,
                blobFileXRayArrayList, dateXRayEdit, descriptionXRayEdit, flagsChange));
        patient.setDoctorLogin(principal.getName());
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

    @GetMapping("/roentgen/{id_patient}/{id_blob:.+}")
    public ResponseEntity<InputStreamResource> getRoentgenImage(@PathVariable("id_patient") String idPatient,
                                                                @PathVariable("id_blob") String idBlob) {
        long id = Long.parseLong(idPatient);
        int idBlobXRay = Integer.parseInt(idBlob);
        BlobFileXRay blobFileXRay = patientService.findById(id).getArrayBlobFileXRay().get(idBlobXRay);
        return ResponseEntity.ok()
                .contentLength(blobFileXRay.getFileXRay().length)
                .contentType(MediaType.valueOf(blobFileXRay.getContentType()))
                .body(new InputStreamResource(new ByteArrayInputStream(blobFileXRay.getFileXRay())));
    }
}
