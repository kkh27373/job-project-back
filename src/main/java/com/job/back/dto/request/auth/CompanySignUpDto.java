package com.job.back.dto.request.auth;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanySignUpDto {
    
    @NotBlank
    @Length(min=11, max=13)
    private String companyTelNumber;

    @NotBlank
    private String companyName;
    
    @NotBlank
    private String companyAddress;

    @URL
    private String companyProfileUrl;
    
    @NotBlank
    @Length(min=8, max=20)
    private String companyPassword;
        
    @NotBlank
    @Length(max = 45)
    @Email
    private String companyEmail;

    private String companyCategory;

    
}
