package org.medservice.services;

import org.medservice.models.Doctor;
import org.springframework.stereotype.Service;

@Service
public interface  DoctorService {

    Doctor findDoctorByUserName(String userName);

    void saveDoctor(Doctor doctor);
}
