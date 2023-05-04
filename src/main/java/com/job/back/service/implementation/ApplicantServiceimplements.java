package com.job.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.common.util.DatabaseJson;
import com.job.back.dto.Applicant_Content_Dto;
import com.job.back.dto.Carrer_Dto;
import com.job.back.dto.License_Dto;
import com.job.back.dto.University_Grade_Dto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.ApplicantScoreResponseDto;
import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;
import com.job.back.entity.CompanySelectComponent_License_Entity;
import com.job.back.entity.CompanySelectComponent_University_Entity;
import com.job.back.repository.ApplicantRepositroy;
import com.job.back.repository.CompanySelectComponent_Carrer_Repository;
import com.job.back.repository.CompanySelectComponent_License_Repository;
import com.job.back.repository.CompanySelectComponent_University_Repository;
import com.job.back.service.ApplicantService;
import com.job.back.service.implementation.ApplicantServiceImplementsFunction.ApplicantFunction;

@Service
public class ApplicantServiceimplements implements ApplicantService{

    @Autowired
    CompanySelectComponent_University_Repository companySelectComponent_University_Repository;
    @Autowired
    CompanySelectComponent_Carrer_Repository companySelectComponent_Carrer_Repository;
    @Autowired
    CompanySelectComponent_License_Repository companySelectComponent_License_Repository;
    @Autowired
    ApplicantRepositroy applicant_Repository;
    

    



    // ! 지원자의 점수를 계산하고 보여주는 ServiceImplemnts
    public ResponseDto<ApplicantScoreResponseDto> show_Applicant_Score(String company_Tel_Number,
                                                                       Applicant_Content_Dto applicantContentDto){
                                                                        
        ApplicantScoreResponseDto data = null; 
        data = new ApplicantScoreResponseDto();                                                       
        

        try{

            

            // ! 지원자가 접속한 company의 Select_component와 지원자의 Select_Component를 비교한다 ==> Applicant에게 점수를 확정하여 보여준다 
            // ? Repository는 매개변수로 받은 전화번호에 해당하는 instance를 반환한다 
            CompanySelectComponent_University_Entity company_university_info = companySelectComponent_University_Repository.findByCompanyTelNumber(company_Tel_Number);
            if(company_university_info==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);
            
            
            
            
            // ! 여기 지원자의 대학교를 보고 회사측에서 지정한 점수를 return 하는 함수 
            data.setApplicant_university_score(ApplicantFunction.University_Matching_Function(company_university_info,applicantContentDto));    

            
            
            
            
            CompanySelectComponent_Carrer_Entity company_carrer_info = companySelectComponent_Carrer_Repository.findByCompanyTelNumber(company_Tel_Number);
            if(company_carrer_info==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);


            data.setApplicant_carrer_score(ApplicantFunction.Carrer_Matching_Function(company_carrer_info, applicantContentDto));

            
            
            
            
            
            CompanySelectComponent_License_Entity company_license_info = companySelectComponent_License_Repository.findByCompanyTelNumber(company_Tel_Number);
            if(company_license_info==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);


            data.setApplicant_license_score(ApplicantFunction.License_Matching_Function(company_license_info, applicantContentDto));

            int applicant_total_score = data.getApplicant_university_score()+data.getApplicant_carrer_score()+data.getApplicant_license_score();
            
            data.setApplicant_total_score(applicant_total_score);

            ApplicantEntity for_Repository_saving = new ApplicantEntity(applicantContentDto.getApplicantEmail(),
                                                                        company_Tel_Number,
                                                                        DatabaseJson.arrayToString(applicantContentDto.getApplicant_FinalEducation()),
                                                                        DatabaseJson.arrayToString(applicantContentDto.getApplicant_Carrer()),
                                                                        DatabaseJson.arrayToString(applicantContentDto.getApplicant_License()),
                                                                        data.getApplicant_total_score());

            System.out.println(for_Repository_saving.getApplicantLicense());  
            System.out.println(data.getApplicant_total_score());
            System.out.println(for_Repository_saving.getApplicantTotalScore());                                                          
            
            // !  Matching 된 정보를 applicantRepository에 save한다 
            applicant_Repository.save(for_Repository_saving);
            


        }catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);




    }


    
}
