package com.job.back.controller;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.job.back.common.constant.ApiPattern;
import com.job.back.service.CompanyFileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "회사파일 모듈")
@RestController
@RequestMapping(ApiPattern.COMPANY_FILE)
public class CompanyFileController {
    
    @Autowired private CompanyFileService compantfileService;
    
    private final String COPANY_UPLOAD = "/companyUpload";
    private final String COMPANY_GET_FILE = "/{companyFileName}";

    @ApiOperation(value = "회사 프로필 업로드",notes = "Request Body에 100MB 이하의 file을 포함하여 요청을 하면, 성공시 다운로드 URL을 반환, 실패시 null을 반환")
    @PostMapping(COPANY_UPLOAD)
    public String companyUplad(
        @ApiParam(value = "업로드할 파일", required = true)
        @RequestParam("file") MultipartFile companyFile
    ) {
        String response = compantfileService.companyUpload(companyFile);
        return response;
    }
    @ApiOperation(value = "회사파일 다운로드",notes = "Path Variable에 fileName을 포함하여 요청하면, 성공시 해당하는 파일의 Resource를 반환, 실패시 null을 반환")
    @GetMapping(value = COMPANY_GET_FILE, produces = {MediaType.ALL_VALUE})
    public Resource getCompanyFile(
        @ApiParam(value="파일명", example="example.png", required=true)
        @PathVariable("companyFileName") String companyFileName
    ) {
        Resource response = compantfileService.getCompanyFile(companyFileName);
        return response;
    }
}
