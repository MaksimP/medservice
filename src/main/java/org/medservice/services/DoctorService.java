package org.medservice.services;

import org.medservice.models.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface  DoctorService {

    Doctor findDoctorByUserName(String userName);

    Doctor findDoctorByLastName(String lastName);

    List<Doctor> findAll();

    void saveDoctor(Doctor doctor);
}
