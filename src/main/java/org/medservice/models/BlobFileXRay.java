package org.medservice.models;

import lombok.Data;

@Data
public class BlobFileXRay {

    private byte[] fileXRay;
    private String contentType;
    private String fileName;
    private String dateXRay;
    private String descriptionXRay;
}
