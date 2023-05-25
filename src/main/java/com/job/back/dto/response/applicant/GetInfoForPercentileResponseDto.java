package com.job.back.dto.response.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInfoForPercentileResponseDto {

    private String applicant_Email;
    private int applicant_Total_Score;
    private String companyTelNumber;


    
}
