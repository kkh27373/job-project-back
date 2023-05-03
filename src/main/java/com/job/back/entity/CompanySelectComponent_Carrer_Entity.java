package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.common.util.DatabaseJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Company_Carrer_Select_Component")
@Table(name = "Company_Carrer_Select_Component")
public class CompanySelectComponent_Carrer_Entity {

    @Id
    private String companyTelNumber;


    private String carrer;
    private int carrer_score;

    public CompanySelectComponent_Carrer_Entity(String companyTelNumber,String[] carrer,int carrer_score){

            this.companyTelNumber = companyTelNumber;
            this.carrer = DatabaseJson.arrayToString(carrer);
            this.carrer_score = carrer_score;

    }
    
}
