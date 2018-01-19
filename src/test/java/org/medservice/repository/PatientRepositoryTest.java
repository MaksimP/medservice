package org.medservice.repository;

import com.mongodb.DBCollection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medservice.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataMongoTest

public class PatientRepositoryTest {

    String collectionName;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private PatientRepository patientRepository;

    @Before
    public void before() {
        collectionName = "patients";
    }

    @After
    public void after() {
        mongoTemplate.dropCollection(collectionName);
    }

    @Test
    public void checkMongoTemplate() {
        assertNotNull(mongoTemplate);
        DBCollection collection = mongoTemplate.createCollection(collectionName);
        assertTrue(mongoTemplate.collectionExists(collectionName));
    }

    @Test
    public void findPatientByLastName() throws Exception {
        Patient patient = new Patient();
        patient.setId(0L);
        patient.setLastName("Петров");
        mongoTemplate.save(patient);
        assertNotNull(patientRepository.findPatientByLastName("Петров"));
    }

    @Test
    public void findPatientById() throws Exception {
        Patient patient = new Patient();
        patient.setId(11L);
        mongoTemplate.save(patient);
        assertNotNull(patientRepository.findPatientById(11L));

    }
}