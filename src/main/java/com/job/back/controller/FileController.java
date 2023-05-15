package com.job.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        @RequestParam("userFile") MultipartFile userFile
        ) {
        String response = userfileService.userUpload(userFile);
        return response;
    }

    @ApiOperation(value="파일 다운로드", notes="Path Variable에 fileName을 포함하여 요청하면, 성공시 해당하는 파일의 Resource를 반환, 실패시 null을 반환")
    @GetMapping(value=USER_GET_FILE, produces = {MediaType.ALL_VALUE})
    public Resource getFile(
        @ApiParam(value="파일명", example="example.png", required=true)
        @PathVariable("userFileName") String userFileName
        ) {
        Resource response = userfileService.getUserFile(userFileName);
        return response;
    }
}
