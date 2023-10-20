package com.seojihoon.boardback.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seojihoon.boardback.service.FileService;

@Service
public class FileServiceImplement implements FileService {

    @Value("${file.path}")
    private String filePath;
    @Value("${file.url}")
    private String fileUrl;

    @Override
    public String upload(MultipartFile file) {

        // description: 빈 파일인지 검증 //
        if (file.isEmpty()) return null;

        // description: 원본 파일명 //
        String originalFileName = file.getOriginalFilename();
        // description: 파일 확장자 구하기 //
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        // description: UUID 형식의 임의의 파일명 생성 //
        String uuid = UUID.randomUUID().toString();
        // description: UUID 형식의 파일명 + 확장자로 새로운 파일명 생성 //
        String saveFileName = uuid + extension;
        // description: 저장할 경로 생성 //
        String savePath = filePath + saveFileName;

        // description: 파일 저장 //
        try {
            file.transferTo(new File(savePath));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        // description: 파일을 불러올 수 있는 경로 반환 //
        String url = fileUrl + saveFileName;
        return url;

    }

    @Override
    public Resource getFile(String fileName) {
        
        Resource resource = null;

        // description: 파일 저장 경로에서 파일명에 해당하는 파일 불러오기 //
        try {
            resource = new UrlResource("file:" + filePath + fileName);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return resource;

    }
    
}
