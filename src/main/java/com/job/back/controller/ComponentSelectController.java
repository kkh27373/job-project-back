package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.Carrer_Dto;
import com.job.back.dto.License_Dto;
import com.job.back.dto.University_Grade_Dto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectCarrerResponseDto;
import com.job.back.dto.response.company.SelectLicenseResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.service.CompanySelectComponentService;

@RestController
@RequestMapping(ApiPattern.SELECT_COMPONENT)
public class ComponentSelectController {

    private final String SELECT_UNIVERSITY = "/university";
    private final String SELECT_CARRER = "/carrer";
    private final String SELECT_LICENSE = "/license";

    @Autowired
    CompanySelectComponentService companyselectcomponentservice;

    @PostMapping(SELECT_UNIVERSITY)
    public ResponseDto<SelectUniversityResponseDto> selectUniversity(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody University_Grade_Dto University
    ){
        ResponseDto<SelectUniversityResponseDto> response = companyselectcomponentservice.select_University_Score(University.getCompanyTelNumber(),
                                                                                                            University.getFirst_grade_university(),University.getFirst_grade_university_score(),
                                                                                                            University.getSecond_grade_university(),University.getSecond_grade_university_score(),
                                                                                                            University.getThird_grade_university(),University.getThird_grade_university_score(),
                                                                                                            University.getEtc_grade_university(),University.getEtc_grade_university_score());

        return response;
        
    }


    @PostMapping(SELECT_CARRER)
    public ResponseDto<SelectCarrerResponseDto> selectCarrer(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody Carrer_Dto Carrer
    ){
        ResponseDto<SelectCarrerResponseDto> response = companyselectcomponentservice.select_Carrer_Score(Carrer.carrer, Carrer.carrer_score);

        return response;


    }

    @PostMapping(SELECT_LICENSE)
    public ResponseDto<SelectLicenseResponseDto> selectLicense(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody License_Dto License
    ){
        ResponseDto<SelectLicenseResponseDto> response = companyselectcomponentservice.select_License_Score(License.license, License.license_score);

        return response;
    }

    
    

}
