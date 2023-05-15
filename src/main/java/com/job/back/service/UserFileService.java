package com.job.back.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UserFileService {
    public String userUpload(MultipartFile userfile);
    public Resource getUserFile(String fileName);

}
