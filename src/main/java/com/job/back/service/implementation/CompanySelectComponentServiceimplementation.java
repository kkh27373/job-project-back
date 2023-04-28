package com.job.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.SelectCarrerResponseDto;
import com.job.back.dto.response.company.SelectLicenseResponseDto;
import com.job.back.dto.response.company.SelectUniversityResponseDto;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;
import com.job.back.entity.CompanySelectComponent_License_Entity;
import com.job.back.entity.CompanySelectComponent_University_Entity;
import com.job.back.repository.CompanySelectComponent_Carrer_Repository;
import com.job.back.repository.CompanySelectComponent_License_Repository;
import com.job.back.repository.CompanySelectComponent_University_Repository;
import com.job.back.service.CompanySelectComponentService;

import io.swagger.models.Response;

@Service
public class CompanySelectComponentServiceimplementation implements CompanySelectComponentService {
    @Autowired
    CompanySelectComponent_University_Repository companySelectComponentRepository;
    @Autowired
    CompanySelectComponent_Carrer_Repository companyselectcomponentcarrerrepository;
    @Autowired
    CompanySelectComponent_License_Repository companyselectcomponentlicenserepository;
    
    public ResponseDto<SelectUniversityResponseDto> select_University_Score(String companyTelNumber,
                                                                            String[] University_grade_one,int first_grade_score,
                                                                            String[] University_grade_two,int second_grade_score,
                                                                            String[] University_grade_three,int third_grade_score,
                                                                            String[] University_grade_etc,int etc_grade_score){

        SelectUniversityResponseDto data = null;


        try{
            CompanySelectComponent_University_Entity companyselectcomponentuniversityentity   =  new CompanySelectComponent_University_Entity(companyTelNumber,
                                                                                                                                    University_grade_one,first_grade_score,
                                                                                                                                    University_grade_two,second_grade_score,
                                                                                                                                    University_grade_three,third_grade_score,
                                                                                                                                    University_grade_etc,etc_grade_score);
            companySelectComponentRepository.save(companyselectcomponentuniversityentity);


            
            data = new SelectUniversityResponseDto(companyselectcomponentuniversityentity);


        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

        
    }
    

    public ResponseDto<SelectCarrerResponseDto> select_Carrer_Score(String[] Carrer,int score){

        

        SelectCarrerResponseDto data = null;

        try{

            CompanySelectComponent_Carrer_Entity companyselectcomponentcarrerentity = new CompanySelectComponent_Carrer_Entity(Carrer,score);
            companyselectcomponentcarrerrepository.save(companyselectcomponentcarrerentity);


            data = new SelectCarrerResponseDto(null);


        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }


    public ResponseDto<SelectLicenseResponseDto> select_License_Score(String[] License,int score){

        SelectLicenseResponseDto data = null;


            try{

                CompanySelectComponent_License_Entity companySelectComponent_License_Entity = new CompanySelectComponent_License_Entity(License,score);
                companyselectcomponentlicenserepository.save(companySelectComponent_License_Entity);

                data = new SelectLicenseResponseDto(companySelectComponent_License_Entity);



            }catch(Exception exception){

                exception.printStackTrace();
                ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }

            return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
            
    }
}
