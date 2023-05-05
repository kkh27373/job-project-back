package com.job.back.service.implementation.ApplicantServiceImplementsFunction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.job.back.dto.Applicant_Total_Score_Dto;
import com.job.back.entity.ApplicantEntity;
import com.job.back.repository.ApplicantRepositroy;
import com.job.back.repository.CompanySelectComponent_Carrer_Repository;
import com.job.back.repository.CompanySelectComponent_License_Repository;
import com.job.back.repository.CompanySelectComponent_University_Repository;

public class Applicant_Percentile_Function {

    @Autowired
    CompanySelectComponent_University_Repository companySelectComponent_University_Repository;
    @Autowired
    CompanySelectComponent_Carrer_Repository companySelectComponent_Carrer_Repository;
    @Autowired
    CompanySelectComponent_License_Repository companySelectComponent_License_Repository;
    @Autowired
    static ApplicantRepositroy applicant_Repository;

    public static double Percentile_Function(List<ApplicantEntity> applicantEntity_arr_OrderBy_Applicant_Total_Score,List<Integer> arr,ApplicantEntity my_applicantEntity){

    

    

    for(ApplicantEntity i:applicantEntity_arr_OrderBy_Applicant_Total_Score){
        
        arr.add(i.getApplicantTotalScore());
    }

    if(arr!=null){
        System.out.println("arr가 null이 아닙니다");
    }

    int k = my_applicantEntity.getApplicantTotalScore();
    double better_than_k =0;

    for(Integer i:arr){
        if(i>k){
            better_than_k++;
        }
    }
    System.out.println(arr.size());
    System.out.println(better_than_k);

    System.out.println((double)2%3); //! 문제  2.0이라고 나오네 
    System.out.println((better_than_k+1)); //! 2.0
    System.out.println((double)arr.size());//!3.0
    System.out.println((better_than_k+1)*100);//! 200.0
     double my_Percentile = ((better_than_k+1)/(double)arr.size())*100;
    return my_Percentile;

    
    
    

    

    

}
    
}
