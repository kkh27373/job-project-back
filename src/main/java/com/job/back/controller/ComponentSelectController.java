package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.service.CompanySelectComponentService;


@RequestMapping(ApiPattern.SELECT_COMPONENT)
public class ComponentSelectController {

    private final String SELECT_UNIVERSITY = "";

    CompanySelectComponentService companyselectcomponentservice;

    @PostMapping(SELECT_UNIVERSITY)
    public ResponseDto<SelectUniversityResponseDto> selectUniversity(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody String[] University,
        @RequestBody int score
    ){
        ResponseDto<SelectUniversityResponseDto> response = companyselectcomponentservice.select_University(University, score);

        return response;
        
    }

    
    

}
