package org.medservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "doctors")
@Data
public class Doctor {

    @Id
    private String id;
   // @Indexed(unique = true)
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String patronymic;

    private String role;

}
