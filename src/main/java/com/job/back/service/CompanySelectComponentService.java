package com.job.back.service;

import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectCarrerResponseDto;
import com.job.back.dto.response.company.SelectLicenseResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;

public interface CompanySelectComponentService {
    public ResponseDto<SelectUniversityResponseDto> select_University_Score(String companyTelNumber,
                                                                            String[] University_grade_one,int first_grade_score,
                                                                            String[] University_grade_two,int second_grade_score,
                                                                            String[] University_grade_third,int third_grade_score,
                                                                            String[] University_grade_etc,int etc_grade_score);
    public ResponseDto<SelectCarrerResponseDto> select_Carrer_Score(String[] Carrer,int score);


    public ResponseDto<SelectLicenseResponseDto> select_License_Score(String[] License,int score);
    
}
