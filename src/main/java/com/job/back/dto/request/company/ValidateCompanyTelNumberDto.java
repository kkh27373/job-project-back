package com.job.back.dto.request.company;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidateCompanyTelNumberDto {
    @NotBlank
    @Email
    private String companyEmail;
}
