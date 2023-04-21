package com.job.back.dto.responser.company;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetTop3CompanyResponseDto {
    //Top3회사를 보여줌
    private String companyProfileUrl;
    private String companyHomepage;
    private String companyName;
    private String companyCategory;
    private String companyAddress;

    public GetTop3CompanyResponseDto(CompanyEntity companyEntity) {
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyHomepage = companyEntity.getCompanyHomepage();
        this.companyName = companyEntity.getCompanyName();
        this.companyCategory = companyEntity.getCompanyCategory();
        this.companyAddress = companyEntity.getCompanyAddress();
    }
}
