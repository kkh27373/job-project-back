package com.job.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant_Content_Dto {

    private String applicantEmail;

    private String[] applicant_FinalEducation;
    private String[] applicant_Carrer;
    private String[] applicant_License;
    


    public String[] getApplicant_FinalEducation(){

        return applicant_FinalEducation;

    }
    

    
}
