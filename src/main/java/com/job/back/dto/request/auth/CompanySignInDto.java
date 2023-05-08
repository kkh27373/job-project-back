package com.job.back.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanySignInDto {
    @NotBlank
    @Email
    @Length(max = 50)
    private String CompanyEmail;
    @NotBlank
    @Length(min = 5, max = 50)
    private String CompanyPassword;
}

