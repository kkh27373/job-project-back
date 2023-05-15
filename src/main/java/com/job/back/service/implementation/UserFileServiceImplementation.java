// package com.job.back.service.implementation;

// import java.io.File;
// import java.util.UUID;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.UrlResource;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;

// import com.job.back.service.UserFileService;

// @Service
// public class UserFileServiceImplementation implements UserFileService {

//    @Value("${user-file.path}")
//    private String USER_FILE_PATH;
//    @Value("${user-file.url}")
//    private String USER_FILE_URL;


//    public String userUplad(MultipartFile file) {

//         if(file.isEmpty()) return null;

//         String originalFileName = file.getOriginalFilename();
//         String extension = originalFileName.substring(originalFileName.lastIndexOf("."));

//         String uuid = UUID.randomUUID().toString();

//         String saveName = uuid + extension;
//         String savePath = USER_FILE_PATH + saveName;

//         try {
//             file.transferTo(new File(savePath));
//         } catch (Exception exception){
//             exception.printStackTrace();
//             return null;
//         }

//         String url = USER_FILE_PATH + saveName;
//         return url;

//     }

//     public Resource getUserFile(String fileName) {

//         Resource resource = null;

//         try{
//             resource = new UrlResource("file:" + USER_FILE_PATH + fileName);
//         } catch(Exception exception){
//             exception.printStackTrace();
//             return null;
//         }

//         return resource;
//     }

    
// }
