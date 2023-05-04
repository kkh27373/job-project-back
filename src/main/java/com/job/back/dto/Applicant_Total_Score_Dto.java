package com.job.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant_Total_Score_Dto {

    private String applicant_Email;
    private int applicant_Total_Score;
    
}
