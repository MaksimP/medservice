package org.medservice.repository;

import org.medservice.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, Long> {

    Patient findPatientByLastName(String lastName);

}
