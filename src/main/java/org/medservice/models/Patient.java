package org.medservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
@Data
public class Patient {

    @Id
    private String id;
   // private String lastNameDoctor;
    private String name;
    private String lastName;
    private String patronymic;
    private String fileName;
    private long length;
}
