package com.job.back.dto.response.company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSearchListResponseDto {
    @Id
    private String companyTelNumber;
    private String companyName;
    private String companyProfileUrl;
    private String companyAddress;
    private String companyCategory;
    private String companyPassword;
    private String companyEmail;

    public GetSearchListResponseDto(CompanyEntity companyEntity){
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyPassword = companyEntity.getCompanyPassword();
        this.companyEmail = companyEntity.getCompanyEmail();
        this.companyCategory = companyEntity.getCompanyCategory();
    }

    public static List<GetSearchListResponseDto> copyList(List<CompanyEntity> companyEntityList){
        List<GetSearchListResponseDto> list = new ArrayList<>();

        for(CompanyEntity companyEntity : companyEntityList){
            GetSearchListResponseDto dto = new GetSearchListResponseDto(companyEntity);
            list.add(dto);
        }

        return list;
    }
}
