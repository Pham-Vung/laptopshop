package org.example.laptopshop.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {
    String handleSaveUploadFile(MultipartFile file, String targetFolder);
}
