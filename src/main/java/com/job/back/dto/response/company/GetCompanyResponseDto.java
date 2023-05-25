package com.job.back.dto.response.company;

import javax.persistence.Id;

import com.job.back.entity.CompanyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 정보 불러오기 Request Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCompanyResponseDto {
    @Id
    @ApiModelProperty(value = "회사 전화번호", example = "051-2222-2222", required = true)
    private String companyTelNumber;
    
    @ApiModelProperty(value = "회사 이름", example = "A회사", required = true)
    private String companyName;
    
    @ApiModelProperty(value = "회사 프로필 사진 URL", example = "https://~", required = true)
    private String companyProfileUrl;
    
    @ApiModelProperty(value = "회사 주소", example = "부산광역시 기장군", required = true)
    private String companyAddress;
    
    @ApiModelProperty(value = "회사 업종", example = "IT", required = true)
    private String companyCategory;
    
    @ApiModelProperty(value = "회사 비밀번호", example = "P!ssW0rd!", required = true)
    private String companyPassword;
    
    @ApiModelProperty(value = "회사 이메일", example = "CompanyEmail@company.com", required = true)
    private String companyEmail;

    
    @ApiModelProperty(value = "회사 홈페이지", example = "https://~", required = false)
    private String companyHomePage;
    
    @ApiModelProperty(value = "회사 소개", example = "안녕하세요 OO회사 입니다.", required = false)
    private String companyContents;
    
    @ApiModelProperty(value = "회사 직원 수", example = "1000", required = false)
    private String companyEmployee;
    
    @ApiModelProperty(value = "회사 연 매출", example = "200000000", required = false)
    private String companyAnnualSales;
    
    @ApiModelProperty(value = "회사 초봉", example = "20000000", required = false)
    private String companyStartingSalary;
    
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
