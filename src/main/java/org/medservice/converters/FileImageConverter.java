package org.medservice.converters;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileImageConverter {

    public byte[] convert(MultipartFile multipartFile) throws IOException {

        byte[] file = multipartFile.getBytes();
        return file;
    }
}
