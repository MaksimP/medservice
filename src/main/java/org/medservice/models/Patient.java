package org.medservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;

@Document(collection = "patients")
@Data
public class Patient {

    @Id
    private Long id;
   // private String lastNameDoctor;
    private String name;
    private String lastName;
    private String patronymic;
    private String fileName;
    private String history;
    private String doctorLogin;
   // private File file;
}
