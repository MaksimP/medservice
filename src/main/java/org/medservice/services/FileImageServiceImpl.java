package org.medservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileImageServiceImpl implements FileImageService{

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public void saveFile(MultipartFile file) {
        try {
            gridFsTemplate.store(file.getInputStream(), "test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public File getFile() {
        return null;
    }
}
