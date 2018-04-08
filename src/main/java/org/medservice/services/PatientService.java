package org.medservice.services;

import org.medservice.models.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    void save(Patient patient);

    void update(Patient patient);

    Patient findByLastName(String lastName);

    Patient findById(Long id);

    List<Patient> findAll();

    List<Patient> findByLastNameAll(String lastName);

    List<Patient> findDistinctByDiagnosis(String diagnosis);
}
