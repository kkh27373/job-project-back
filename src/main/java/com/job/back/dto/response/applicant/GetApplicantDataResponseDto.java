package com.job.back.dto.response.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetApplicantDataResponseDto {
    
    private String userEmail;
    private String applicant_FinalEducation;
    private String applicant_Carrer;
    private String applicant_License;
    


    
}
