package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.University_Grade_Dto;
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
        @Valid @RequestBody University_Grade_Dto University
    ){
        ResponseDto<SelectUniversityResponseDto> response = companyselectcomponentservice.select_University(University.first_grade_university,University.first_grade_university_score,
                                                                                                            University.second_grade_university,University.second_grade_university_score,
                                                                                                            University.third_grade_university,University.third_grade_university_score,
                                                                                                            University.etc_grade_university,University.etc_grade_university_score);

        return response;
        
    }

    
    

}
