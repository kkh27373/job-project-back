package com.job.back.dto.response.company;

import java.util.ArrayList;
import java.util.List;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyTop3ListResponseDto {
    private String companyTelNumber;
    private String companyName;
    private String companyProfileUrl;
    private String companyAddress;
    private String companyCategory;
    private String companyPassword;
    
    public GetCompanyTop3ListResponseDto(CompanyEntity companyEntity) {
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyCategory = companyEntity.getCompanyCategory();
        this.companyPassword = companyEntity.getCompanyPassword();
    }

    public static List<GetCompanyTop3ListResponseDto> copyList(List<CompanyEntity> companyEntitiesList) {
        List<GetCompanyTop3ListResponseDto> list = new ArrayList<>();

        for (CompanyEntity companyEntity: companyEntitiesList) {
            GetCompanyTop3ListResponseDto dto = new GetCompanyTop3ListResponseDto(companyEntity);
            list.add(dto);
        }
        return list;
    }
}
