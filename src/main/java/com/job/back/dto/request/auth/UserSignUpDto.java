package com.job.back.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignUpDto {

    @NotBlank
    @Length(max = 45)
    @Email
    private String userEmail;

    @NotBlank
    @Length(min=8, max=20)
    private String userPassword;

    @NotBlank
    @Length(min=11, max=13)
    private String userTelNumber;

    @NotBlank
    private String userName;

    @NotBlank
    private String userAddress;

    @NotBlank
    private String userAge;

    @NotBlank
    private String userGender;
}
