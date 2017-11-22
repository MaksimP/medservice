package org.medservice.services;

import com.mongodb.gridfs.GridFSDBFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileImageServiceImpl implements FileImageService{

    public static final Logger logger = LoggerFactory.getLogger("FileImageServiceImpl");

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public void saveFile(MultipartFile file, String fileName) {
        try {
            gridFsTemplate.store(file.getInputStream(), fileName, file.getContentType());
        } catch (IOException e) {
            logger.error("could not save file");
        }
    }

    @Override
    public void updateFile(MultipartFile file, String filename) {
        try {
            gridFsTemplate.store(file.getInputStream(), filename, file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GridFSDBFile getFileName(String reference) {
        return gridFsTemplate.findOne(new Query(Criteria.where("filename").is(reference)));
    }

    public boolean isPresentFile(String fileName) {
        if (gridFsTemplate.findOne(new Query(Criteria.where("filename").is(fileName))) != null) {
            return true;
        } else {
            return false;
        }
    }
}
