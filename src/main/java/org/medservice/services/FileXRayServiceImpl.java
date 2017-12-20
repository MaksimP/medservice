package org.medservice.services;

import org.medservice.converters.FileImageConverter;
import org.medservice.models.BlobFileXRay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class FileXRayServiceImpl implements FileXRayService{

    @Autowired
    private FileImageConverter fileImageConverter;

    private static final Logger logger = LoggerFactory.getLogger("FileXRayServiceImpl");

    @Override
    public ArrayList<BlobFileXRay> createListBlob(MultipartFile[] files, String[] dateXRay, String[] descriptionXRay) {
        ArrayList<BlobFileXRay> blobFileXRayArrayList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            BlobFileXRay blobFileXRay = createBlob(files, dateXRay, descriptionXRay, i);
            blobFileXRayArrayList.add(blobFileXRay);
        }
        return blobFileXRayArrayList;
    }

    @Override
    public ArrayList<BlobFileXRay> updateListBlob(MultipartFile[] files, String[] dateXRay, String[] descriptionXRay,
                                                  String[] flags, ArrayList<BlobFileXRay> blobFileXRayArrayList) {

        if (blobFileXRayArrayList == null && !files[0].isEmpty()) {
            blobFileXRayArrayList = createListBlob(files, dateXRay, descriptionXRay);
        } else {
            if (flags != null) {
                for (int i = 0; i < flags.length; i++) {
                    blobFileXRayArrayList.remove(Integer.parseInt(flags[i]));
                }
                blobFileXRayArrayList.trimToSize();
            }
            if (!files[0].isEmpty()) {
                for (int i = 0; i < files.length; i++) {
                    BlobFileXRay blobFileXRay = createBlob(files, dateXRay, descriptionXRay, i);
                    blobFileXRayArrayList.add(blobFileXRay);
                }
            }
        }
        return blobFileXRayArrayList;
    }

    private BlobFileXRay createBlob(MultipartFile[] files, String[] dateXRay, String[] descriptionXRay, int index) {
        BlobFileXRay blobFileXRay = new BlobFileXRay();
        MultipartFile file = files[index];

        blobFileXRay.setContentType(file.getContentType());
        blobFileXRay.setFileName(file.getName());
        blobFileXRay.setDateXRay(dateXRay[index]);
        blobFileXRay.setDescriptionXRay(descriptionXRay[index]);
        try {
            blobFileXRay.setFileXRay(fileImageConverter.convert(file));
        } catch (IOException e) {
            logger.error("could not convert multipartfile");
        }
        return blobFileXRay;
    }
}
