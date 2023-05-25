package com.job.back.dto.response.company;

import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.CompanySelectComponent_Carrer_Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사가 요구하는 지원자의 경력 Response Body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectCarrerResponseDto {

    @ApiModelProperty(value = "회사 전화번호", example = "051-2222-2222", required = true)
    private String companyTelNumber;

    @ApiModelProperty(value = "경력", example = "5년", required = true)
    private String[] carrer;

    @ApiModelProperty(value = "경력 점수", example = "20", required = true)
    private int carrer_score;
    
    public SelectCarrerResponseDto(CompanySelectComponent_Carrer_Entity companyselectcomponentcarrerentity){

        this.companyTelNumber = companyselectcomponentcarrerentity.getCompanyTelNumber();
        this.carrer = DatabaseJson.stringToArray(companyselectcomponentcarrerentity.getCarrer());
        this.carrer_score = companyselectcomponentcarrerentity.getCarrer_score();

    }

    
    
}
