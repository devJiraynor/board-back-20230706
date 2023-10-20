package com.seojihoon.boardback.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    String upload(MultipartFile file);
    Resource getFile(String fileName);

}
