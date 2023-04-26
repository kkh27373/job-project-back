package com.job.back.dto.request.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

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

    @URL
    private String userProfileUrl;

    @NotBlank
    @Length(min=11, max=15)
    private String userTelNumber;

    @NotBlank
    private String userName;

    @NotBlank
    private String userAddress;

    // ! int 는 NotBlank 를 사용하지 못한다 
    // ! ==> int는 null 도 사용 불가 ==> Integer 사용 ==> Not Null을 사용해준다 
    @NotNull
    private Integer userAge;

    @NotBlank
    private String userGender;
}
