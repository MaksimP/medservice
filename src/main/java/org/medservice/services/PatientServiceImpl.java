package org.medservice.services;


import org.medservice.models.Patient;
import org.medservice.repository.PatientRepository;
import org.medservice.repository.PatientRepositoryCustom;
import org.medservice.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final String nameCollection = "patients";

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientRepositoryCustom patientRepositoryCustom;

    @Autowired
    private SequenceRepository sequenceRepository;

    @Override
    public void save(Patient patient) {
        patient.setId(sequenceRepository.getNextSequenceId(nameCollection));
        patientRepository.save(patient);
    }

    @Override
    public void update(Patient patient) {
        patientRepository.save(patient);
        patientRepositoryCustom.updateListNameFilesPatient(patient);
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

    @Override
    public List<Patient> findByLastNameAll(String lastName) {
        return patientRepository.findAllByLastName(lastName);
    }

    @Override
    public List<Patient> findDistinctByDiagnosis(String diagnosis) {
        return patientRepository.findByDiagnosisContainingIgnoreCase(diagnosis);
    }


}
