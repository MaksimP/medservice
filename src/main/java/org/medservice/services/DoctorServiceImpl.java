package org.medservice.services;

import org.medservice.models.Doctor;
import org.medservice.repository.DoctorRepository;
import org.medservice.repository.RoleRepository;
import org.medservice.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private static final String nameCollection = "doctors";

    private static final String role = "USER";

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SequenceRepository sequenceRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Doctor findDoctorByUserName(String userName) {
        return doctorRepository.findDoctorByUserName(userName);
    }

    @Override
    public Doctor findDoctorByLastName(String lastName) {
        return doctorRepository.findDoctorByLastName(lastName);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    /*public List<Doctor> findAllDoctor() {
        return doctorRepository.findAll(Example<Doctor)
    }*/



    @Override
    public void saveDoctor(Doctor doctor) {
        doctor.setRole(role);
        doctor.setId(sequenceRepository.getNextSequenceId(nameCollection));
        doctor.setPassword(encoder.encode(doctor.getPassword()));
        doctorRepository.save(doctor);
    }
}