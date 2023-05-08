package com.job.back.service.implementation.ApplicantServiceImplementsFunction;

import com.job.back.common.util.DatabaseJson;
import com.job.back.dto.Applicant_Content_Dto;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;
import com.job.back.entity.CompanySelectComponent_License_Entity;
import com.job.back.entity.CompanySelectComponent_University_Entity;

public class Applicant_Total_Score_Function {

    public static int University_Matching_Function(CompanySelectComponent_University_Entity companyselect_University,
                                                   Applicant_Content_Dto applicant_content_dto){

    String[] company_select_uni_arr = DatabaseJson.stringToArray(companyselect_University.getFirst_grade_university());

    System.out.println("오늘은 여기 1 "+company_select_uni_arr);
    
    
    String [] applicant_finalEducation_arr= applicant_content_dto.getApplicant_FinalEducation();

    System.out.println("오늘은 여기"+applicant_finalEducation_arr);
    

    // ! for 문을 돌면서 해당 문자열에 지원자의 학교가 있는지 없는지 확인 
    for(int i=0;i<company_select_uni_arr.length;i++){
        company_select_uni_arr[i] =company_select_uni_arr[i].trim();
        for(int j=0;j<applicant_finalEducation_arr.length;j++){

            applicant_finalEducation_arr[j] = applicant_finalEducation_arr[j].trim();

            if(company_select_uni_arr[i].equals(applicant_finalEducation_arr[j])){
                System.out.println("회사가 원하는 회사는 :"+company_select_uni_arr[i]);
                System.out.println("지원자의 학교는 : "+applicant_finalEducation_arr[j]);
                return companyselect_University.getFirst_grade_university_score();
            }



                
            
            
            
                

            
        }

        if(i+1>=company_select_uni_arr.length){
            System.out.println("지원자의 학교가 없습니다 ");
        }
        
    }
    // ! 모든 경우에 대해서 return 값을 설정해 놔야 
    // ! for 문 밖에서도 어떻게 함수가 끝나는지 확인해 봐야 
    return 0;
}


public static int Carrer_Matching_Function(CompanySelectComponent_Carrer_Entity companyselect_carrer,
                                           Applicant_Content_Dto applicant_content_dto){


    String[] company_select_Carrer_arr = DatabaseJson.stringToArray(companyselect_carrer.getCarrer());

    String[] applicant_Carrer_arr = applicant_content_dto.getApplicant_Carrer();



    for(int i=0;i<company_select_Carrer_arr.length;i++){
        company_select_Carrer_arr[i] =company_select_Carrer_arr[i].trim();
        for(int j=0;j<applicant_Carrer_arr.length;j++){

            applicant_Carrer_arr[j] = applicant_Carrer_arr[j].trim();

            if(company_select_Carrer_arr[i].equals(applicant_Carrer_arr[j])){
                System.out.println("회사가 원하는 회사는 :"+company_select_Carrer_arr[i]);
                System.out.println("지원자의 학교는 : "+applicant_Carrer_arr[j]);
                return companyselect_carrer.getCarrer_score();
            }



                
            
            
            
                

            
        }

        if(i+1>=company_select_Carrer_arr.length){
            System.out.println("지원자의 경력은 우대 대상이 아닙니다  ");
        }
        
    }

    return 0;                           

}




public static int License_Matching_Function(CompanySelectComponent_License_Entity companyselect_license,
                                            Applicant_Content_Dto applicant_content_dto){


    String[] company_select_License_arr = DatabaseJson.stringToArray(companyselect_license.getLicense());

    String[] applicant_License_arr = applicant_content_dto.getApplicant_License();


    for(int i=0;i<company_select_License_arr.length;i++){
        company_select_License_arr[i] =company_select_License_arr[i].trim();
        for(int j=0;j<applicant_License_arr.length;j++){

            applicant_License_arr[j] = applicant_License_arr[j].trim();

            if(company_select_License_arr[i].equals(applicant_License_arr[j])){
                System.out.println("회사가 원하는 회사는 :"+company_select_License_arr[i]);
                System.out.println("지원자의 학교는 : "+applicant_License_arr[j]);
                return companyselect_license.getLicense_score();
            }



                
            
            
            
                

            
        }

        if(i+1>=company_select_License_arr.length){
            System.out.println("지원자의 경력은 우대 대상이 아닙니다  ");
        }
        
    }

    return 0; 

}



}
