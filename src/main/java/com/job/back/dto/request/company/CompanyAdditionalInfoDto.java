package com.job.back.dto.request.company;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyAdditionalInfoDto {
    
    private String companyTelNumber; 

    private String companyProfileUrl;

    private String companyCategory; 
    
    private String companyHomepage;

    private String companyContents;
    
    private String companyEmployee;
    
    private String companyAnnualSales;
    
    private String companyStartingSalary;
    }
