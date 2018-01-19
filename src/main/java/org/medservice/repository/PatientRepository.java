package org.medservice.repository;

import org.medservice.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface PatientRepository extends MongoRepository<Patient, Long> {

    Patient findPatientByLastName(String lastName);

    Patient findPatientById(Long id);

    List<Patient> findAllByLastName(String lastName);

}