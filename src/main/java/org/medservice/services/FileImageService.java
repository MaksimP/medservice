package org.medservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public interface FileImageService {

    void saveFile(MultipartFile file);

    File getFile();
}
