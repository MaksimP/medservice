package org.medservice.services;


import org.medservice.models.Patient;
import org.medservice.repository.PatientRepository;
import org.medservice.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final String nameCollection = "patients";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SequenceRepository sequenceRepository;

    @Override
    public void save(Patient patient) {
        patient.setId(sequenceRepository.getNextSequenceId(nameCollection));
        patientRepository.save(patient);
    }

    @Override
    public Patient findByLastName(String lastName) {
        return patientRepository.findPatientByLastName(lastName);
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findPatientById(id);
    }


    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
