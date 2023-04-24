package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Company")
@Table(name = "Company")
public class CompanyEntity {
    @Id
    private String companyTelNumber;
    private String companyName;
    private String companyProfileUrl;
    private String companyAddress;
    private String companyCategory;
    private String companyAnnualIncomeAvarage;
    private String companyEstablishmentDate;
    private String companyHomepage;
    private String companyEmployeeNumber;
    private String companySales;
    private String companyPassword;
    private String companyEmail;

    
}
