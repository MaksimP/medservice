package org.medservice.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@Document(collection = "patients")
@Data
public class Patient {

    @Id
    private Long id;
   // private String lastNameDoctor;
    private String name;
    private String lastName;
    private String patronymic;
    private ArrayList<String> listFileNames;
    private String history;
    private String doctorLogin;
    private ArrayList<MultipartFile> files;
}
