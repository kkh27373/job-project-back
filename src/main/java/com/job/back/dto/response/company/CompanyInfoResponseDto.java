package com.job.back.dto.response.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 정보 response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoResponseDto {
    @ApiModelProperty(value = "회사 정보 결과", example = "true", required = true)
    private boolean result;
}
