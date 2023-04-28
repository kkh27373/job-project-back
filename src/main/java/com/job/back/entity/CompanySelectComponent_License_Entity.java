package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String companyTelNumber;

    public String[] license;
    public int license_score;

    public CompanySelectComponent_License_Entity(String license[],int license_score){

        

    }
    
}
