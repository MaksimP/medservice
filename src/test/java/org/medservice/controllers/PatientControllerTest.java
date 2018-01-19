package org.medservice.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.medservice.services.FileXRayServiceImpl;
import org.medservice.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PatientController.class)
public class PatientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PatientServiceImpl patientService;

    @MockBean
    FileXRayServiceImpl fileXRayService;

    @Test
    public void getPatients() throws Exception {
        mockMvc.perform(get("/patients_table"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void addPatient() throws Exception {
    }

    @Test
    public void addPatientPost() throws Exception {
    }

    @Test
    public void updatePatient() throws Exception {
    }

    @Test
    public void updatePatientPost() throws Exception {
    }

    @Test
    public void getPatient() throws Exception {
    }

    @Test
    public void getRoentgenImage() throws Exception {
        mockMvc.perform(get("/roentgen/{id_patient}/{id_blob:.+}"))
                .andExpect(content().contentType(MediaType.IMAGE_JPEG));
    }

}