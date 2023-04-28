package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.dto.request.auth.CompanySignUpDto;

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
    private String companyPassword;
    private String companyEmail;

    public CompanyEntity(CompanySignUpDto dto){
        this.companyTelNumber = dto.getCompanyTelNumber();
        this.companyName = dto.getCompanyName();
        this.companyProfileUrl = dto.getCompanyProfileUrl();
        this.companyAddress = dto.getCompanyAddress();
        this.companyPassword = dto.getCompanyPassword();
        this.companyEmail = dto.getCompanyEmail();
        this.companyCategory = dto.getCompanyCategory();
    }
}
