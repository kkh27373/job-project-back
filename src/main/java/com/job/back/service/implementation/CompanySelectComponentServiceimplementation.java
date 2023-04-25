package com.job.back.service.implementation;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectCarrerResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.entity.CompanySelectComponent_University_Entity;

import com.job.back.repository.CompanySelectComponent_University_Repository;
import com.job.back.service.CompanySelectComponentService;

import io.swagger.models.Response;

public class CompanySelectComponentServiceimplementation implements CompanySelectComponentService {

    CompanySelectComponent_University_Repository companySelectComponentRepository;
    
    public ResponseDto<SelectUniversityResponseDto> select_University_Score(String[] University_grade_one,int first_grade_score,
                                                                            String[] University_grade_two,int second_grade_score,
                                                                            String[] University_grade_three,int third_grade_score,
                                                                            String[] University_grade_etc,int etc_grade_score){

        SelectUniversityResponseDto data = null;


        try{
            CompanySelectComponent_University_Entity companySelectComponentEntity   =  new CompanySelectComponent_University_Entity(University_grade_one,first_grade_score,
                                                                                                                                    University_grade_two,second_grade_score,
                                                                                                                                    University_grade_three,third_grade_score,
                                                                                                                                    University_grade_etc,etc_grade_score);
            companySelectComponentRepository.save(companySelectComponentEntity);


            
            data = SelectUniversityResponseDto(companySelectComponentEntity);


        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

        
    }
    

    public ResponseDto<SelectCarrerResponseDto> select_Carrer(String[] Carrer,int score){

        SelectCarrerResponseDto data = null;

        try{





        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }
}
