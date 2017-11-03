package org.medservice.services;

import org.medservice.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    void save(Patient patient);

    Patient findByLastName(String lastName);

    List<Patient> findAll();
}
