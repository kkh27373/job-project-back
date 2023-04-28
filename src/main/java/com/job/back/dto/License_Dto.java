package com.job.back.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class License_Dto {

    private  String companyTelNumber;

    private String[] license;
    private int license_score;
    
}
