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
    private String companyAnnualIncomeAvarage;
    private String companyEstablishmentDate;
    private String companyHomepage;
    private String companyEmployeeNumber;
    private String companySales;
    private String companyPassword;
    private String companyEmail;

    public GetCompanyResponseDto(CompanyEntity companyEntity){
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyPassword = companyEntity.getCompanyPassword();
        this.companyEmail = companyEntity.getCompanyEmail();
        this.companyCategory = companyEntity.getCompanyCategory();
    }
}
