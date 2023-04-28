package com.job.back.service.implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.request.user.PatchProfileDto;
import com.job.back.dto.request.user.PatchUserComponentDto;
import com.job.back.dto.request.user.ValidateUserEmailDto;
import com.job.back.dto.request.user.ValidateUserTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.dto.response.user.GetUserResponseDto;
import com.job.back.dto.response.user.ValidateEmailResponseDto;
import com.job.back.dto.response.user.ValidateTelNumberResponseDto;
import com.job.back.entity.UserEntity;
import com.job.back.repository.UserReposiotory;
import com.job.back.service.UserService;

@Service
public class UserServiceImplement implements UserService {

    @Autowired UserReposiotory userReposiotory;



    public ResponseDto<PatchProfileDto> patchProfile(String userEmail, PatchProfileDto dto ){

        PatchProfileDto data = null;

        String profile = dto.getUserProfileUrl();


        try{
            
            UserEntity userEntity = userReposiotory.findByUserEmail(userEmail);
            if(userEntity==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);

            
            userEntity.setUserProfileUrl(profile);
            userReposiotory.save(userEntity);

            data = new PatchProfileDto(userEntity);



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
