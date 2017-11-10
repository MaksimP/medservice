package org.medservice.services;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileImageService {

    void saveFile(MultipartFile file, String filename);

    void updateFile(MultipartFile file, String filename);

    GridFSDBFile getFileName(String reference);
}
