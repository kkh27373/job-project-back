package com.job.back.dto.response.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 전화번호 중복체크")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateCompanyTelNumberResponseDto {
    @ApiModelProperty(value = "회사 전화번호 중복체크 결과", example = "true", required = true)
    private boolean result;
}
