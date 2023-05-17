package com.job.back.service.implementation;

import java.io.File;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.job.back.service.CompanyFileService;

@Service
public class CompanyFileServiceImplements implements CompanyFileService   {

    @Value("${file.path}")
    private String COMPANY_FILE_PATH;
    @Value("${companyfile.url}")
    private String COMPANY_FILE_URL;
    
    public String companyUpload(MultipartFile companyFile) {

        if(companyFile.isEmpty()) return null;

        String companyOriginalFileName = companyFile.getOriginalFilename();
        String companyextension = companyOriginalFileName.substring(companyOriginalFileName.lastIndexOf("."));

        String companyuuid = UUID.randomUUID().toString();

        String companySaveName = companyuuid + companyextension;
        String companySavePath = COMPANY_FILE_PATH + companySaveName;

        try{
            companyFile.transferTo(new File(companySavePath));
        }catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        String companturl = COMPANY_FILE_URL + companySaveName;
        return companturl;
        
    }

    
    public Resource getCompanyFile(String companyFileName) {

        Resource resource = null;

        try{
            resource = new UrlResource("file" + COMPANY_FILE_PATH + companyFileName);
        }catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return resource;
    }
    
}
