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

    private final String COMPANY_SELECT_UNIVERSITY = "/company/university";
    private final String COMPANY_SELECT_CARRER = "/company/carrer";
    private final String COMPANY_SELECT_LICENSE = "/company/license";

    @Autowired
    CompanySelectComponentService companyselectcomponentservice;

    @PostMapping(COMPANY_SELECT_UNIVERSITY)
    public ResponseDto<SelectUniversityResponseDto> selectUniversity(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody University_Grade_Dto University
    ){

        System.out.println("Controller에서 가장 먼저 받는 부분 :"+University.getFirst_grade_university());
        ResponseDto<SelectUniversityResponseDto> response = companyselectcomponentservice.select_University_Score(University.getCompanyTelNumber(),
                                                                                                            University.getFirst_grade_university(),University.getFirst_grade_university_score(),
                                                                                                            University.getSecond_grade_university(),University.getSecond_grade_university_score(),
                                                                                                            University.getThird_grade_university(),University.getThird_grade_university_score(),
                                                                                                            University.getEtc_grade_university(),University.getEtc_grade_university_score());

        return response;
        
    }


    @PostMapping(COMPANY_SELECT_CARRER)
    public ResponseDto<SelectCarrerResponseDto> selectCarrer(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody Carrer_Dto Carrer
    ){
        ResponseDto<SelectCarrerResponseDto> response = companyselectcomponentservice.select_Carrer_Score(Carrer.getCompanyTelNumber(),Carrer.getCarrer(), Carrer.getCarrer_score());

        return response;


    }

    @PostMapping(COMPANY_SELECT_LICENSE)
    public ResponseDto<SelectLicenseResponseDto> selectLicense(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody License_Dto License
    ){
        ResponseDto<SelectLicenseResponseDto> response = companyselectcomponentservice.select_License_Score(License.getCompanyTelNumber(),License.getLicense(), License.getLicense_score());

        return response;
    }

    
    

}
