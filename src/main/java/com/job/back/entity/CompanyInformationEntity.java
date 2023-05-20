package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.dto.request.company.CompanyInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Company_Information")
@Table(name = "Company_Information")
public class CompanyInformationEntity {
    @Id
    private String companyTelNumber;
    private String companyHomepage;
    private String companyContents;
    private String companyEmployee;
    private String companyAnnualSales;
    private String companyStartingSalary;

    public CompanyInformationEntity(CompanyInfoDto dto) {
        this.companyTelNumber = dto.getCompany_Tel_Number();
        this.companyHomepage = dto.getCompany_Homepage();
        this.companyContents = dto.getCompany_Contents();
        this.companyEmployee = dto.getCompany_Employee();
        this.companyAnnualSales = dto.getCompany_Annual_Sales();
        this.companyStartingSalary = dto.getCompany_Starting_Salary();
    }

    public void patchCompany(CompanyInfoDto dto) {
        this.companyHomepage = dto.getCompany_Homepage();
        this.companyEmployee = dto.getCompany_Employee();
        this.companyAnnualSales = dto.getCompany_Annual_Sales();
        this.companyStartingSalary = dto.getCompany_Starting_Salary();
    }
    
    public void patchCompanyContents(CompanyInfoDto dto) {
        this.companyContents = dto.getCompany_Contents();
    }
}
