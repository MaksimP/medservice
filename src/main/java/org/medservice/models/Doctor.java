package org.medservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "doctors")
@Data
public class Doctor {

    @Id
    private long id;
    @Indexed(unique = true)
    private String userName;
    private String name;
    private String lastName;
    private String patronymic;
    private String password;

}
