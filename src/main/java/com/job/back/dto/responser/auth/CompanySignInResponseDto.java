package com.job.back.dto.responser.auth;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanySignInResponseDto {
    // 회사 전화번호
    private String companyTelNumber;
    //회사 이름
    private String companyName;
    // 회사 프로필
    private String companyProfileUrl;
    // 회사 주소
    private String companyAddress;
    // 회사 업종
    private String companyCategory;
    // 패스워드
    private String companyPassword;
    //이메일
    private String companyEmail;
    //로그인시 받을 토큰
    private String token;
    // 토큰 만료기간
    private int expiredTime;
    
    public CompanySignInResponseDto(CompanyEntity companyEntity, String token) {
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyPassword = companyEntity.getCompanyPassword();
        this.companyEmail = companyEntity.getCompanyEmail();
        this.token = token;
        this.expiredTime = 3600000;
    }
}