package org.example.laptopshop.service.implement;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletContext;

import org.example.laptopshop.service.interfaces.IUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UploadService implements IUploadService {
    private final ServletContext servletContext;

    @Override
    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        String rootPath = servletContext.getRealPath("/resources/images");
        String finalName = "";

        try {
            byte[] bytes = file.getBytes();

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists()) dir.mkdirs();

            // Create the file on server
            finalName = UUID.randomUUID() + "-" + file.getOriginalFilename();

            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);
            // uuid

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finalName;
    }
}
