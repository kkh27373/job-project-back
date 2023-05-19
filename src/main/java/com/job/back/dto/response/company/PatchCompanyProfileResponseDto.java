package com.job.back.dto.response.company;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchCompanyProfileResponseDto {
    
    private String companyProfileUrl;

    public PatchCompanyProfileResponseDto(CompanyEntity companyEntity){
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
    }
}
