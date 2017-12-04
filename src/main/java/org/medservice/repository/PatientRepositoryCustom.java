package org.medservice.repository;

import org.medservice.models.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoryCustom {

    void updateListNameFilesPatient(Patient patient);
}
