package com.job.back.dto.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("유저 전화번호 중복체크 response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateTelNumberResponseDto {
    @ApiModelProperty(value = "유저 전화번호 중복체크 결과", example = "true", required = true)
    private boolean result;
    
}
