package com.job.back.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.common.util.DatabaseJson;
import com.job.back.dto.Applicant_Content_Dto;
import com.job.back.dto.Applicant_Total_Score_Dto;
import com.job.back.dto.Carrer_Dto;
import com.job.back.dto.License_Dto;
import com.job.back.dto.University_Grade_Dto;
import com.job.back.dto.request.applicant.Applicant_Email_Dto;
import com.job.back.dto.request.applicant.GetInfoForPercentileDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.ApplicantPercentileResponseDto;
import com.job.back.dto.response.applicant.ApplicantScoreResponseDto;
import com.job.back.dto.response.applicant.GetInfoForPercentileResponseDto;
import com.job.back.dto.response.company.GetMyApplyCompanyResponseDto;
import com.job.back.entity.ApplicantEntity;
import com.job.back.entity.CompanyEntity;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;
import com.job.back.entity.CompanySelectComponent_License_Entity;
import com.job.back.entity.CompanySelectComponent_University_Entity;
import com.job.back.repository.ApplicantRepositroy;
import com.job.back.repository.CompanyRepository;
import com.job.back.repository.CompanySelectComponent_Carrer_Repository;
import com.job.back.repository.CompanySelectComponent_License_Repository;
import com.job.back.repository.CompanySelectComponent_University_Repository;
import com.job.back.service.ApplicantService;
import com.job.back.service.implementation.ApplicantServiceImplementsFunction.Applicant_Percentile_Function;
import com.job.back.service.implementation.ApplicantServiceImplementsFunction.Applicant_Total_Score_Function;



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
    @Autowired 
    CompanyRepository company_Repository;
    

    



    // ! 지원자의 점수를 계산하고 보여주는 ServiceImplemnts
    @Override
    public ResponseDto<ApplicantScoreResponseDto> show_Applicant_Total_Score(String company_Tel_Number,
                                                                       Applicant_Content_Dto applicantContentDto){
                                                                        
        ApplicantScoreResponseDto data = null; 
        data = new ApplicantScoreResponseDto();  
        
        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<applicantContentDto.getApplicant_FinalEducation().length;i++){
            System.out.println("for문 돈다"+applicantContentDto.getApplicant_FinalEducation()[i]);
        }

        System.out.println("company_Tel_Number: "+company_Tel_Number);

        
       
    //    System.out.println("아이고 :"+applicantContentDto.getApplicant_FinalEducation().toString());
    //    System.out.println(applicantContentDto.getApplicant_Carrer());                                                                 

    //    System.out.println();                                                                 
    //    System.out.println();                                                                 

        try{

            // ! 지원자가 접속한 company의 Select_component와 지원자의 Select_Component를 비교한다 ==> Applicant에게 점수를 확정하여 보여준다 
            // ? Repository는 매개변수로 받은 전화번호에 해당하는 instance를 반환한다 
            CompanySelectComponent_University_Entity company_university_info = companySelectComponent_University_Repository.findByCompanyTelNumber(company_Tel_Number);
            if(company_university_info==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);
            
            
            
            
            System.out.println("여길 보세요@@@@@@@@@@2@@"+applicantContentDto);
            System.out.println("여기를 보시오2"+applicantContentDto.getApplicant_FinalEducation());
            // ! 여기 지원자의 대학교를 보고 회사측에서 지정한 점수를 return 하는 함수 
            data.setApplicant_university_score(Applicant_Total_Score_Function.University_Matching_Function(company_university_info,applicantContentDto));    
        
            CompanySelectComponent_Carrer_Entity company_carrer_info = companySelectComponent_Carrer_Repository.findByCompanyTelNumber(company_Tel_Number);
            if(company_carrer_info==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);


            data.setApplicant_carrer_score(Applicant_Total_Score_Function.Carrer_Matching_Function(company_carrer_info, applicantContentDto));     
            
            CompanySelectComponent_License_Entity company_license_info = companySelectComponent_License_Repository.findByCompanyTelNumber(company_Tel_Number);
            if(company_license_info==null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);


            data.setApplicant_license_score(Applicant_Total_Score_Function.License_Matching_Function(company_license_info, applicantContentDto));

            int applicant_total_score = data.getApplicant_university_score()+data.getApplicant_carrer_score()+data.getApplicant_license_score();
            
            data.setApplicant_total_score(applicant_total_score);

            ApplicantEntity for_Repository_saving = new ApplicantEntity(applicantContentDto.getApplicantEmail(),
                                                                        company_Tel_Number,
                                                                        DatabaseJson.arrayToString(applicantContentDto.getApplicant_FinalEducation()),
                                                                        DatabaseJson.arrayToString(applicantContentDto.getApplicant_Carrer()),
                                                                        DatabaseJson.arrayToString(applicantContentDto.getApplicant_License()),
                                                                        data.getApplicant_total_score()
                                                                        );

                                                                    
            
            // !  Matching 된 정보를 applicantRepository에 save한다 
            applicant_Repository.save(for_Repository_saving);

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }

    @Override
    public ResponseDto<ApplicantPercentileResponseDto> show_Applicant_Percentile(String company_Tel_Number,Applicant_Total_Score_Dto my_dto){

        ApplicantPercentileResponseDto data =new ApplicantPercentileResponseDto();
        

        
        List<Integer> arr = new ArrayList<>();

        double my_Percentile;

        try{

            // ! 해당 회사에 지원한 모든 지원자의 entity를 applicant_Total_Score 내림차순으로 정렬해서 보여준다
            List<ApplicantEntity> applicantEntity_arr_OrderBy_Applicant_Total_Score = applicant_Repository
                    .findByApplicantCompanyTelNumberOrderByApplicantTotalScoreDesc(company_Tel_Number);
            // ! 해당 회사에 지원한 모든 지원자의 entity
            // List<ApplicantEntity> applicantEntity_arr=
            // applicant_Repository.findByApplicantCompanyTelNumber(company_Tel_Number);
            // ! 나의 백분위를 알고싶은 지원자의 entity
            // ! 지원자의 이메일과 지원회사의 전화번호를 이용해서 두가지 모두를 매개변수로 받아서 사용한다
            System.out.println("여기요: "+my_dto.getApplicant_Email()+"요기요 2 :"+company_Tel_Number);
            ApplicantEntity my_applicantEntity = applicant_Repository
                    .findByApplicantUserEmailAndApplicantCompanyTelNumber(my_dto.getApplicant_Email(),company_Tel_Number);

            my_Percentile = Applicant_Percentile_Function.Percentile_Function(applicantEntity_arr_OrderBy_Applicant_Total_Score, arr, my_applicantEntity);

            System.out.println("당신은 상위 : "+my_Percentile + "% 입니다.");


            //? applicantRepository에 들어가서 column값 하나만 더하면 되는데 굳이 새로운 객체 만들어서 덮어씌우기?
            // ? ==> 너무 비효율적인데 


            ApplicantEntity applicantEntity = new ApplicantEntity(my_applicantEntity.getApplicantUserEmail(), 
                                                                  company_Tel_Number, 
                                                                  my_applicantEntity.getApplicantFinalEducation(), 
                                                                  my_applicantEntity.getApplicantCarrer(), 
                                                                  my_applicantEntity.getApplicantLicense(), 
                                                                  my_dto.getApplicant_Total_Score(), my_Percentile);


            data.setApplicant_percentile(my_Percentile);

            applicant_Repository.save(applicantEntity);


        } catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    public ResponseDto<List<GetMyApplyCompanyResponseDto>> getMyApplyCompanyList(String companyEmail,Applicant_Email_Dto applicantEmail_dto){

        List<GetMyApplyCompanyResponseDto> data = new ArrayList<>();
        

        try{
            // ? 1명 N개의 정보 (김현태가 지원한 ==> A회사 B회사 C회사)
            List<ApplicantEntity> applicant_company_list = applicant_Repository.findByApplicantUserEmail(applicantEmail_dto.getApplicantEmail());
           
            // ? A회사 B  C회사에 대한 정보를 가져와야해 
            

            for(int i=0;i<applicant_company_list.size();i++){

                CompanyEntity company = company_Repository.findByCompanyTelNumber(applicant_company_list.get(i).getApplicantCompanyTelNumber()); 

                
                GetMyApplyCompanyResponseDto responseDto = new GetMyApplyCompanyResponseDto();
                responseDto.setApplicantTotalScore(applicant_company_list.get(i).getApplicantTotalScore());
                responseDto.setCompanyTelNumber(company.getCompanyTelNumber());
                responseDto.setCompanyProfileUrl(company.getCompanyProfileUrl());
                responseDto.setCompanyPassword(company.getCompanyPassword());
                responseDto.setCompanyName(company.getCompanyName());
                responseDto.setCompanyCategory(company.getCompanyCategory());
                responseDto.setCompanyAddress(company.getCompanyAddress());

                data.add(responseDto);

            }
            
        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);

        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

        
    }

    public ResponseDto<List<GetInfoForPercentileResponseDto>> getInfoForPercentile(String applicantEmail){
        System.out.println("여기 2: "+applicantEmail);
        List<GetInfoForPercentileResponseDto> data = new ArrayList<>();

        try{
            List<ApplicantEntity> applicantentities = applicant_Repository.findByApplicantUserEmail(applicantEmail);

            for(int i=0;i<applicantentities.size();i++){

                GetInfoForPercentileResponseDto ex = new GetInfoForPercentileResponseDto();

                ex.setCompanyTelNumber(applicantentities.get(i).getApplicantCompanyTelNumber());
                System.out.println("여기가 문제예요!!:"+applicantentities.get(i).getApplicantCompanyTelNumber());
                ex.setApplicant_Email(applicantentities.get(i).getApplicantUserEmail()); 
                ex.setApplicant_Total_Score(applicantentities.get(i).getApplicantTotalScore());

                data.add(ex);

            }

            

            

        }catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);

        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
    
}


  
