package org.medservice.services;

import org.medservice.models.Doctor;
import org.medservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Doctor findDoctorByUserName(String userName) {
        return doctorRepository.findDoctorByUserName(userName);
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctor.setPassword(encoder.encode(doctor.getPassword()));
    }
}
