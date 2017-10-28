package org.medservice.repository;

import org.medservice.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("doctorRepository")
public interface DoctorRepository extends MongoRepository<Doctor, Long>{

    Doctor findDoctorByLastName(String lastname);

    Doctor findDoctorByUserName(String username);
}
