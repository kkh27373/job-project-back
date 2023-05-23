package com.job.back.service;

import com.job.back.dto.Applicant_Content_Dto;
import com.job.back.dto.Applicant_Total_Score_Dto;
import com.job.back.dto.Carrer_Dto;
import com.job.back.dto.License_Dto;
import com.job.back.dto.University_Grade_Dto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.ApplicantPercentileResponseDto;
import com.job.back.dto.response.applicant.ApplicantScoreResponseDto;
import com.job.back.dto.response.company.GetMyApplyCompanyResponseDto;

public interface ApplicantService {

    public ResponseDto<ApplicantScoreResponseDto> show_Applicant_Total_Score( String company_Tel_Number,
                                                                        Applicant_Content_Dto applicantScoreDto);



    public ResponseDto<ApplicantPercentileResponseDto> show_Applicant_Percentile(String company_Tel_Number,Applicant_Total_Score_Dto applicantTotalDto);

    public ResponseDto<GetMyApplyCompanyResponseDto> getMyApplyCompanyList(String companyEmail,String applicantEmail);

    
}
