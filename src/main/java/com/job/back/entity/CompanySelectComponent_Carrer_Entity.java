package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

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


    public String[] carrer;
    public int carrer_score;

    public CompanySelectComponent_Carrer_Entity(String carrer,int carrer_score){

    }
    
}
