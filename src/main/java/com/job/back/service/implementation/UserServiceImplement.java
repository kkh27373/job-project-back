package com.job.back.service.implementation;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.common.util.DatabaseJson;
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
import com.job.back.dto.response.user.AddUserWishListResponseDto;
import com.job.back.dto.response.user.GetUserResponseDto;
import com.job.back.dto.response.user.PatchUserComponentResponseDto;
import com.job.back.dto.response.user.ValidateEmailResponseDto;
import com.job.back.dto.response.user.ValidateTelNumberResponseDto;
import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.UserEntity;
import com.job.back.entity.UserWishListEntity;
import com.job.back.repository.ApplicantRepositroy;
import com.job.back.repository.UserReposiotory;
import com.job.back.repository.UserWishListRepository;
import com.job.back.service.UserService;

@Service
public class UserServiceImplement implements UserService {

    @Autowired UserReposiotory userRepository;
    @Autowired ApplicantRepositroy applicantRepository;
    @Autowired UserWishListRepository userwishlistRepository;



    // ! UserSelectComponent(FinalEducation,Carrer,License) 만 수정 할 수 있는 함수 
    public ResponseDto<PatchUserComponentResponseDto> patchUserSelectComponent(String userEmail, User_Select_Component_Dto dto ){
                                                                                            // ! User_Select_Component_Dto에는 RequestBody의 Json 타입 에 들어가는게  온다
        PatchUserComponentResponseDto data = null;

        String[] userFinalEducation = dto.getUserFinalEducation();
        String[] userCarrer = dto.getUserCarrer();
        String[] userLicense = dto.getUserLicense();
         
        System.out.println("실행0"+Arrays.toString(userFinalEducation));

        try{
            
            //! UserRepository에서 입력된 Email이 있는지를 찾아봐야지  
            // ! (String userEmail, User_Select_Component_Dto dto ) 그냥 userEmail을 매개변수로 받으면 안되고, dto의 getUserEmail을 해서 받아야 한다 
            // ! 나중에 RequestBody에서 이메일을 받으니까 
            UserEntity userentity = userRepository.findByUserEmail(dto.getUserEmail());
            if(userentity==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_USER);


            System.out.println("실행1"+userentity.getUserEmail());
            // ! 실행1rlagusxo96652@naver.com


            // ! 여기서 UserEntity에 저장할 때만String[]에서 String으로 바꾼다 
            userentity.setUserFinalEducation(DatabaseJson.arrayToString(userFinalEducation));
            System.out.println("실행2"+userentity.getUserFinalEducation());
            // ! 실행2[Ljava.lang.String;@13d31368
            // ! String[] 의 주소가 userentity로 저장된다 ==> 어떻게 하면 주소가 아니라 값으로 저장할 수 있을까 ?


            // ! 들어갈때는 String으로 들어가고 Postman에 성공여부 보여줄 때는 String[] 로 보여진다 
            userentity.setUserCarrer(DatabaseJson.arrayToString(userCarrer));
            userentity.setUserLicense(DatabaseJson.arrayToString(userLicense));
            userRepository.save(userentity);


            // ! data에 들어갈때 ["서비스업 10년","제조업 5년",""] 이렇게 들어가야 한다
            data = new PatchUserComponentResponseDto(userentity);



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);


    }
    public ResponseDto<GetUserResponseDto> getUser(String userEmail){

        GetUserResponseDto   data = null;


        try{
            UserEntity userentity = userRepository.findByUserEmail(userEmail);
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
        data = new ValidateEmailResponseDto();


        try{

            Boolean result = userRepository.existsByUserEmail(dto.getUserEmail());
            if(result){
                data.setResult(false);
                System.out.println("false를 보냄"+data);
                
                

            }

            else{
                data.setResult(true);
                System.out.println("true를 보냄"+data);
            
            }






        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateUserTelNumberDto dto){


        ValidateTelNumberResponseDto data = null;
        data = new ValidateTelNumberResponseDto();


        try{
            boolean result = userRepository.existsByUserTelNumber(dto.getUserTelNumber());

            if(result){
                data.setResult(false);
            }

            else{
                data.setResult(true);
            }

            



        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }
    public ResponseDto<AddUserWishListResponseDto> addUserWishList(String userEmail,String company_tel_number){
        
        AddUserWishListResponseDto data = new AddUserWishListResponseDto();
        
        
        try{
            // ? 일차적으로 내가 원하는 회사의 전화번호를 통해 내가 원하는 회사가 맞는지 회사 확인 ==> 1차 정재 작업 
            // List<ApplicantEntity>  applicantList =applicantRepositroy.findByApplicantCompanyTelNumber(company_tel_number);
            // ? 2차적으로 내가 userEmail이 맞는지 확인 ==>2차 정재 작업 

            // UserWishListEntity userWishListEntity = new UserWishListEntity(company_tel_number,userEmail,);

            ApplicantEntity applicantEntity = applicantRepository.findByApplicantCompanyTelNumberAndApplicantUserEmail(company_tel_number,userEmail);
            System.out.println(applicantEntity);
            
            data.setWish_company_my_total_score(applicantEntity.getApplicantTotalScore());
            data.setWish_company_my_percentile(applicantEntity.getApplicantPercentile());

            UserWishListEntity userwishlistentity = new UserWishListEntity(company_tel_number,userEmail,applicantEntity.getApplicantTotalScore(),applicantEntity.getApplicantPercentile());


            userwishlistRepository.save(userwishlistentity);


        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);


    }

        

    
}
