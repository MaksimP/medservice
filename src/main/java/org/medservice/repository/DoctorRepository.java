package org.medservice.repository;

import org.medservice.models.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public interface DoctorRepository extends MongoRepository<Doctor, Long>{

    Doctor findDoctorByLastName(String lastName);

    Doctor findDoctorByUserName(String username);

}
