package com.job.back.dto.response.company;

import javax.persistence.Id;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCompanyResponseDto {
    @Id
    private String companyTelNumber;
    private String companyName;
    private String companyProfileUrl;
    private String companyAddress;
    private String companyCategory;
    private String companyPassword;
    private String companyEmail;

    private String companyHomePage;
    private String companyEmployee;
    private String companyAnnualSales;
    private String companyStartingSalary;
    private String companyContents;


    public GetCompanyResponseDto(CompanyEntity companyEntity){
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyPassword = companyEntity.getCompanyPassword();
        this.companyEmail = companyEntity.getCompanyEmail();
        this.companyCategory = companyEntity.getCompanyCategory();

        this.companyHomePage = companyEntity.getCompanyHomePage();
        this.companyEmployee = companyEntity.getCompanyEmployee();
        this.companyAnnualSales = companyEntity.getCompanyAnnualSales();
        this.companyStartingSalary = companyEntity.getCompanyStartingSalary();
        this.companyContents = companyEntity.getCompanyContents();
    }
}
