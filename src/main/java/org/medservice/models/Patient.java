package org.medservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
@Data
public class Patient {

    @Id
    private Long id;
    private String lastNameDoctor;
    private String namePatient;
    private String lastNamePatient;
    private String fileName;
    private long length;
}
