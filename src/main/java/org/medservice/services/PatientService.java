package org.medservice.services;

import org.medservice.models.Patient;

public interface PatientService {

    void save(Patient patient);

    Patient findByLastName(String lastName);
}
