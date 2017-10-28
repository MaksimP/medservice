package org.medservice.services;


import org.medservice.models.Patient;
import org.medservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findByLastName(String lastName) {
        return patientRepository.findPatientByLastName(lastName);
    }
}
