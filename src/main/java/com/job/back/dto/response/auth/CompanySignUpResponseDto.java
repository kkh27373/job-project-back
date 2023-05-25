package com.job.back.dto.response.auth;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("회사 회원가입 response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanySignUpResponseDto {
    private boolean status;
}