package com.job.back.dto.response.auth;

import com.job.back.entity.CompanyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 로그인 response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanySignInResponseDto {

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
    @ApiModelProperty(value = "JWT", example = "3600000", required = true)
    private String token;
    @ApiModelProperty(value = "회사", example = "", required = true)
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
