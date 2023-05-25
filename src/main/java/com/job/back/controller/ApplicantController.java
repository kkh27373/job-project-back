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
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.ApplicantPercentileResponseDto;
import com.job.back.dto.response.applicant.ApplicantScoreResponseDto;
import com.job.back.dto.response.applicant.GetApplicantDataResponseDto;
import com.job.back.dto.response.company.GetMyApplyCompanyResponseDto;
import com.job.back.service.ApplicantService;
import com.job.back.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPattern.APPLICANT)
@Api(description = "지원자 모듈")
public class ApplicantController {

    private final String APPLICANT_SCORE_PER_COMPANY = "/score/{company_Tel_Number}";
    private final String APPLICANT_PERCENTILE = "/percentile/{company_Tel_Number}";
    private final String GET_APPLICANT_DATA = "/get-data";
    private final String GET_MY_COMPANY_LIST_URL = "/my-list";


    @Autowired
    ApplicantService applicantService;
    @Autowired
    UserService userService;

    @ApiOperation(value = "지원자 정보 불러오기",notes = "유저이메일을 통해 지원자 정보를 가져온다 만약 실패시 실패 메세지를 띄운다.")
    @GetMapping(GET_APPLICANT_DATA)
    public ResponseDto<GetApplicantDataResponseDto> getApplicantData(
        @AuthenticationPrincipal String email
    ){
        ResponseDto<GetApplicantDataResponseDto> response = userService.getApplicantData(email);

        return response;
    }

    @ApiOperation(value = "특정 회사가 지원자에게 주는 총 점수",notes = "Applicant_Score_Dto에 User의 select_component(final_education,carrer,license)가 담겨서 보내진다 만약 실패 실패 메세지를 띄운다. ")
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

    @ApiOperation(value = "특정 회사에 지원한 지원자의 백분위",notes = "RequestBody에 Applicant_Total_Score_Dto를 같이 요청하면 요청한 회사에서 백분위가 나온다. ")
    @PostMapping(APPLICANT_PERCENTILE)
    public ResponseDto<ApplicantPercentileResponseDto> showApplicantPercentile(
        @AuthenticationPrincipal String email,
        @Valid @RequestBody Applicant_Total_Score_Dto dto,
        @PathVariable String company_Tel_Number
    ){

        ResponseDto<ApplicantPercentileResponseDto> response = applicantService.show_Applicant_Percentile(company_Tel_Number,dto);

        return response;

    }

    @ApiOperation(value = "지원자가 지원한 회사 리스트", notes = " 회사 이메일과 지원자이메일을 통해 지원자가 지원한 회사인지 확인하고 화면에 띄운다")
    @PostMapping(GET_MY_COMPANY_LIST_URL)
    public ResponseDto<List<GetMyApplyCompanyResponseDto>> getMyCompanyListUrl(@AuthenticationPrincipal String companyEmail,
                                                                         @Valid @RequestBody Applicant_Email_Dto applicantEmail){

        ResponseDto<List<GetMyApplyCompanyResponseDto>> response = applicantService.getMyApplyCompanyList(companyEmail,applicantEmail);
        return response;


    }


    
}
