package org.medservice.repository;

import org.medservice.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class PatientRepositoryCustomImpl implements PatientRepositoryCustom{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void updateListNameFilesPatient(Patient patient) {
        Query query = new Query(Criteria.where("id").is(patient.getId()));
        Update update = new Update();
        update.pullAll("listFileNames", new String[] {""});
        mongoTemplate.updateFirst(query, update, Patient.class);
    }
}
