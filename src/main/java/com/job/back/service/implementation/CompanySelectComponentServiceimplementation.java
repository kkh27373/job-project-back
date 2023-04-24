package com.job.back.service.implementation;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.entity.CompanySelectComponentEntity;
import com.job.back.repository.CompanySelectComponentRepository;
import com.job.back.service.CompanySelectComponentService;

public class CompanySelectComponentServiceimplementation implements CompanySelectComponentService {

    CompanySelectComponentRepository companySelectComponentRepository;
    
    public ResponseDto<SelectUniversityResponseDto> select_University(String[] University_grade_one,String[] University_grade_two,String[] University_grade_three,String[] University_grade_etc,int score){

        SelectUniversityResponseDto data = null;


        try{
            CompanySelectComponentEntity companySelectComponentEntity   =  new CompanySelectComponentEntity(University);
            companySelectComponentRepository.save(companySelectComponentEntity);


            



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSucess(ResponseMessage.SUCCESS, data);

        
    }
    
}
