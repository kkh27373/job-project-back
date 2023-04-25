package com.job.back.dto.response.company;

import com.job.back.entity.CompanySelectComponent_License_Entity;

public class SelectLicenseResponseDto {

    private String companyTelNumber;

    private String[] license;

    private int license_score;


    public SelectLicenseResponseDto(CompanySelectComponent_License_Entity companySelectComponent_License_Entity){
        this.companyTelNumber = companySelectComponent_License_Entity.getCompanyTelNumber();
        this.license = companySelectComponent_License_Entity.getLicense();
        this.license_score = companySelectComponent_License_Entity.getLicense_score();
        
    }
    
}
