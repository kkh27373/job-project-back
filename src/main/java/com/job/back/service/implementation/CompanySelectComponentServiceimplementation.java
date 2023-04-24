package com.job.back.service.implementation;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.service.CompanySelectComponentService;

public class CompanySelectComponentServiceimplementation implements CompanySelectComponentService {
    
    public ResponseDto<SelectUniversityResponseDto> select_University(String[] University,int score){

        SelectUniversityResponseDto data = null;


        try{
            
            



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSucess(ResponseMessage.SUCCESS, data);

        
    }
    
}
