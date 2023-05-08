package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.common.util.DatabaseJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Company_License_Select_Component")
@Entity(name = "Company_License_Select_Component")
public class CompanySelectComponent_License_Entity {

    @Id
    private String companyTelNumber;

    private String license;
    private int license_score;

    public CompanySelectComponent_License_Entity(String companyTelNumber, String license[],int license_score){

        this.companyTelNumber = companyTelNumber;
        this.license = DatabaseJson.arrayToString(license);
        this.license_score = license_score;

        

    }
    
}
