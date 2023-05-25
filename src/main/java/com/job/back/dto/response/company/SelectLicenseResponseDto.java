package com.job.back.dto.response.company;

import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.CompanySelectComponent_License_Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사가 요구하는 자격증 Request Body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectLicenseResponseDto {

    @ApiModelProperty(value = "회사 번호", example = "051-2222-2222", required = true)
    private String companyTelNumber;

    @ApiModelProperty(value = "자격증", example = "컴퓨터 활용능력 2급", required = true)
    private String[] license;

    @ApiModelProperty(value = "자격증 점수", example = "20", required = true)
    private int license_score;


    public SelectLicenseResponseDto(CompanySelectComponent_License_Entity companySelectComponent_License_Entity){
        this.companyTelNumber = companySelectComponent_License_Entity.getCompanyTelNumber();
        this.license = DatabaseJson.stringToArray(companySelectComponent_License_Entity.getLicense());
        this.license_score = companySelectComponent_License_Entity.getLicense_score();
        
    }
    
}
