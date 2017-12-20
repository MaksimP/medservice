package org.medservice.services;

import org.medservice.models.BlobFileXRay;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Service
public interface FileXRayService {

    ArrayList<BlobFileXRay> createListBlob(MultipartFile[] file, String[] dateXRay, String[] descriptionXRay);

    ArrayList<BlobFileXRay> updateListBlob(MultipartFile[] file, String[] dateXRay, String[] descriptionXRay,
                                           String[] flags, ArrayList<BlobFileXRay> blobFileXRays);
}
