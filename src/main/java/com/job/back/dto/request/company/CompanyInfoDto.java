package com.job.back.dto.request.company;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyInfoDto {
    @NotBlank
    private String company_Tel_Number; 
    @NotBlank
    private String company_Homepage;

    private String company_Contents;
    @NotBlank
    private String company_Employee;
    @NotBlank
    private String company_Annual_Sales;
    @NotBlank
    private String company_Starting_Salary;
    }
