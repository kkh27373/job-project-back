package com.job.back.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.Applicant_Content_Dto;
import com.job.back.dto.Applicant_Total_Score_Dto;
import com.job.back.dto.request.applicant.Applicant_Email_Dto;
import com.job.back.dto.request.applicant.GetInfoForPercentileDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.ApplicantPercentileResponseDto;
import com.job.back.dto.response.applicant.ApplicantScoreResponseDto;
import com.job.back.dto.response.applicant.GetApplicantDataResponseDto;
import com.job.back.dto.response.applicant.GetInfoForPercentileResponseDto;
import com.job.back.dto.response.company.GetMyApplyCompanyResponseDto;
import com.job.back.service.ApplicantService;
import com.job.back.service.UserService;

@RestController
@RequestMapping(ApiPattern.APPLICANT)
public class ApplicantController {

    private final String APPLICANT_SCORE_PER_COMPANY = "/score/{company_Tel_Number}";
    private final String APPLICANT_PERCENTILE = "/percentile/{company_Tel_Number}";
    private final String GET_APPLICANT_DATA = "/get-data";
    private final String GET_MY_COMPANY_LIST_URL = "/my-list";
    private final String GET_INFO_FOR_PERCENTILE = "/get-info";


    @Autowired
    ApplicantService applicantService;
    @Autowired
    UserService userService;


    @GetMapping(GET_APPLICANT_DATA)
    public ResponseDto<GetApplicantDataResponseDto> getApplicantData(
        @AuthenticationPrincipal String email
    ){
        ResponseDto<GetApplicantDataResponseDto> response = userService.getApplicantData(email);

        return response;
    }


    @PostMapping(APPLICANT_SCORE_PER_COMPANY)
    public ResponseDto<ApplicantScoreResponseDto> showApplicantTotalScore(
        @AuthenticationPrincipal String email,
        // ! Applicant_Score_Dto에 User의 select_component(final_education,carrer,license)가 담겨서 보내진다
        @Valid @RequestBody Applicant_Content_Dto dto,
        @PathVariable String company_Tel_Number
    ){

        
        ResponseDto<ApplicantScoreResponseDto> response = applicantService.show_Applicant_Total_Score(company_Tel_Number,dto);

        return response;


    }

    @PostMapping(APPLICANT_PERCENTILE)
    public ResponseDto<ApplicantPercentileResponseDto> showApplicantPercentile(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody Applicant_Total_Score_Dto dto,
        @PathVariable String company_Tel_Number
    ){
        System.out.println("전화번호 받았더"+company_Tel_Number);

        ResponseDto<ApplicantPercentileResponseDto> response = applicantService.show_Applicant_Percentile(company_Tel_Number,dto);

        return response;

    }


    @PostMapping(GET_MY_COMPANY_LIST_URL)
    public ResponseDto<List<GetMyApplyCompanyResponseDto>> getMyCompanyListUrl(@AuthenticationPrincipal String companyEmail,
                                                                         @Valid @RequestBody Applicant_Email_Dto applicantEmail){

        ResponseDto<List<GetMyApplyCompanyResponseDto>> response = applicantService.getMyApplyCompanyList(companyEmail,applicantEmail);
        return response;


    }

    @GetMapping(GET_INFO_FOR_PERCENTILE)
    public ResponseDto<List<GetInfoForPercentileResponseDto>> getInfoForPercentile(@AuthenticationPrincipal String applicantEmail){
        System.out.println("여기봐 : "+applicantEmail);
        ResponseDto<List<GetInfoForPercentileResponseDto>> response = applicantService.getInfoForPercentile(applicantEmail);
        return response;

    }


    
}
