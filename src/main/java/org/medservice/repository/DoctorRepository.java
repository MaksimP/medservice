package org.medservice.repository;


import org.medservice.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, Long>{

    Doctor findDoctorByLastName(String lastname);
}
