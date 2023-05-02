package com.job.back.service;

import com.job.back.dto.Applicant_Content_Dto;
import com.job.back.dto.Carrer_Dto;
import com.job.back.dto.License_Dto;
import com.job.back.dto.University_Grade_Dto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.ApplicantScoreResponseDto;

public interface ApplicantService {

    public ResponseDto<ApplicantScoreResponseDto> show_Applicant_Score( String company_Tel_Number,
                                                                        Applicant_Content_Dto applicantScoreDto);
    
}
