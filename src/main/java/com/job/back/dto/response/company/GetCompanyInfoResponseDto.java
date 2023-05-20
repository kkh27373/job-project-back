package com.job.back.dto.response.company;

import com.job.back.entity.CompanyInformationEntity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 추가정보 가져오기")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCompanyInfoResponseDto {
    private CompanyInformationEntity companyTelNumber;
}
