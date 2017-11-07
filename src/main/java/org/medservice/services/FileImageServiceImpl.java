package org.medservice.services;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileImageServiceImpl implements FileImageService{

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public void saveFile(MultipartFile file, String fileName) {
        try {
            gridFsTemplate.store(file.getInputStream(), fileName, file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GridFSDBFile getFileName(String reference) {
        return gridFsTemplate.findOne(new Query(Criteria.where("filename").is(reference)));
    }
}
