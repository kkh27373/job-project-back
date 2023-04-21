package com.job.back.dto.request.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidateUserEmailDto {
    @NotBlank
    @Email
    private String userEmail;
}
