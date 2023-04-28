package com.job.back.service.implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.User_Select_Component_Dto;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.request.user.PatchUserComponentDto;
import com.job.back.dto.request.user.ValidateUserEmailDto;
import com.job.back.dto.request.user.ValidateUserTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.dto.response.user.GetUserResponseDto;
import com.job.back.dto.response.user.PatchUserComponentResponseDto;
import com.job.back.dto.response.user.ValidateEmailResponseDto;
import com.job.back.dto.response.user.ValidateTelNumberResponseDto;
import com.job.back.entity.UserEntity;
import com.job.back.entity.UserSelectComponentEntity;
import com.job.back.repository.UserReposiotory;
import com.job.back.repository.UserSelectComponentRepositoy;
import com.job.back.service.UserService;

@Service
public class UserServiceImplement implements UserService {

    @Autowired UserSelectComponentRepositoy userSelectComponentRepositoy;
    @Autowired UserReposiotory userReposiotory;



    // ! UserSelectComponent(FinalEducation,Carrer,License) 만 수정 할 수 있는 함수 
    public ResponseDto<PatchUserComponentResponseDto> patchUserSelectComponent(String userEmail, User_Select_Component_Dto dto ){

        PatchUserComponentResponseDto data = null;

        String[] userFinalEducation = dto.getUserFinalEducation();
        String[] userCarrer = dto.getUserCarrer();
        String[] userLicense = dto.getUserLicense();
         


        try{
            
            UserSelectComponentEntity userselectcomponententity = userSelectComponentRepositoy.findByUserEmail(userEmail);
            if(userselectcomponententity==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            
            userselectcomponententity.setUserFinalEducation(userFinalEducation);
            userselectcomponententity.setUserCarrer(userCarrer);
            userselectcomponententity.setUserLicense(userLicense);
            userSelectComponentRepositoy.save(userselectcomponententity);

            data = new PatchUserComponentResponseDto(userselectcomponententity);



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);


    }
    public ResponseDto<GetUserResponseDto> getUser(String userEmail){

        GetUserResponseDto   data = null;


        try{
            UserEntity userentity = userReposiotory.findByUserEmail(userEmail);
            if(userentity==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);


            data = new GetUserResponseDto(userentity);




        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

        

    }
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateUserEmailDto dto){

        ValidateEmailResponseDto data = null;


        try{



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateUserTelNumberDto dto){


        ValidateTelNumberResponseDto data = null;


        try{



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }


        

    
}
