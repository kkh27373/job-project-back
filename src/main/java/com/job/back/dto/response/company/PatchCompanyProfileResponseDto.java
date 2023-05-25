package com.job.back.dto.response.company;

import com.job.back.entity.CompanyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 프로필 사진 URL 파일 Response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchCompanyProfileResponseDto {
    
    @ApiModelProperty(value = "회사 프로필 사진 URL", example = "http://~")
    private String companyProfileUrl;

    public PatchCompanyProfileResponseDto(CompanyEntity companyEntity){
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
    }
}
