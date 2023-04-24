package com.job.back.service;

public interface CompanySelectComponentService {
    public ResponseDto<SelectUniversityResponseDto> select_University(String[] University,int score);
    public ResponseDto<SelectCarrerResponseDto> select_Carrer(String[] Carrer,int score);
    
}
