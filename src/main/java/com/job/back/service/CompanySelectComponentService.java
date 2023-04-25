package com.job.back.service;

import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;

public interface CompanySelectComponentService {
    public ResponseDto<SelectUniversityResponseDto> select_University_Score(String[] University_grade_one,int first_grade_score,
                                                                            String[] University_grade_two,int second_grade_score,
                                                                            String[] University_grade_third,int third_grade_score,
                                                                            String[] University_grade_etc,int etc_grade_score);
    public ResponseDto<SelectCarrerResponseDto> select_Carrer(String[] Carrer,int score);
    
}
