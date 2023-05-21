package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.dto.request.auth.CompanySignUpDto;
import com.job.back.dto.request.company.CompanyAdditionalInfoDto;

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
    private String companyCategory;
    private String companyAddress;
    private String companyPassword;
    private String companyEmail;

    private String companyHomepage;
    private String companyContents;
    private String companyEmployee;
    private String companyAnnualSales;
    private String companyStartingSalary;

    public CompanyEntity(CompanySignUpDto dto){
        this.companyTelNumber = dto.getCompanyTelNumber();
        this.companyName = dto.getCompanyName();
        this.companyAddress = dto.getCompanyAddress();
        this.companyPassword = dto.getCompanyPassword();
        this.companyEmail = dto.getCompanyEmail();
    }


    //  ? 회사에 대한 추가 정보 
    public CompanyEntity(CompanyAdditionalInfoDto dto){
        this.companyHomepage = dto.getCompanyHomepage();
        this.companyContents = dto.getCompanyContents();
        this.companyEmployee = dto.getCompanyEmployee();
        this.companyAnnualSales = dto.getCompanyAnnualSales();
        this.companyStartingSalary = dto.getCompanyStartingSalary();
        this.companyProfileUrl = dto.getCompanyProfileUrl();
        this.companyCategory = dto.getCompanyCategory();
    }


}
