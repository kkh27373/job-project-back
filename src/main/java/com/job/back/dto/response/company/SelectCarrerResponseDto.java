package com.job.back.dto.response.company;

import com.job.back.entity.CompanySelectComponent_Carrer_Entity;

public class SelectCarrerResponseDto {


    private String companyTelNumber;

    private String[] carrer;

    private int carrer_score;


    public SelectCarrerResponseDto(CompanySelectComponent_Carrer_Entity companyselectcomponentcarrerentity){

        this.companyTelNumber = companyselectcomponentcarrerentity.getCompanyTelNumber();
        this.carrer = companyselectcomponentcarrerentity.getCarrer();
        this.carrer_score = companyselectcomponentcarrerentity.getCarrer_score();

    }

    
    
}
