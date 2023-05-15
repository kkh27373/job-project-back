package com.job.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.job.back.common.constant.ApiPattern;
import com.job.back.service.UserFileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "파일 모듈")
@RestController
@RequestMapping(ApiPattern.USER_FILE)
public class FileController {

    @Autowired private UserFileService userfileService;


    private final String USERUPLOAD ="/userUpload";
    private final String USER_GET_FILE = "/{userFileName}";
    
    @ApiOperation(value="파일 업로드", notes="Request Body에 100MB 이하의 file을 포함하여 요청을 하면, 성공시 다운로드 URL을 반환, 실패시 null을 반환")
    @PostMapping(USERUPLOAD)
    public String upload(
        @ApiParam(value = "업로드할 파일", required = true)
        @RequestParam("file") MultipartFile userfile
        ) {
        String response = userfileService.userUpload(userfile);
        return response;
    }
}
