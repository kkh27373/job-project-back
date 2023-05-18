package com.job.back.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface CompanyFileService {
    public String companyUpload(MultipartFile companyFile);
    public Resource getCompanyFile(String companyFileName);
}
