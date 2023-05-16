package com.job.back.service.implementation;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.job.back.service.UserFileService;

@Service
public class UserFileServiceImplementation implements UserFileService {

   @Value("${file.path}")
   private String USER_FILE_PATH;
   @Value("${file.url}")
   private String USER_FILE_URL;


   public String userUpload(MultipartFile userFile) {

        if(userFile.isEmpty()) return null;

        String originalFileName = userFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

        String uuid = UUID.randomUUID().toString();

        String saveName = uuid + extension;
        String savePath = USER_FILE_PATH + saveName;

        try {
            userFile.transferTo(new File(savePath));
        } catch (Exception exception){
            exception.printStackTrace();
            return null;
        }

        String url = USER_FILE_URL + saveName;
        return url;

    }

    public Resource getUserFile(String userFileName) {

        Resource resource = null;

        try{
            resource = new UrlResource("file:" + USER_FILE_PATH + userFileName);
        } catch(Exception exception){
            exception.printStackTrace();
            return null;
        }

        return resource;
    }

    
}
