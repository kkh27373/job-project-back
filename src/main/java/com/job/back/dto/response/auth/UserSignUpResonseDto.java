package com.job.back.dto.response.auth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("유저 회원가입 response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpResonseDto {
    @ApiModelProperty(value = "회원가입 결과", example = "true", required = true)
    private boolean status;
}
