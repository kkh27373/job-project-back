package com.job.back.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidateUserTelNumberDto {
    @NotBlank
    @Length(max = 13)
    private String userTelNumber;
}
