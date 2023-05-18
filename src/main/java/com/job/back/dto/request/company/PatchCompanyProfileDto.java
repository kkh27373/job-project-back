package com.job.back.dto.request.company;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchCompanyProfileDto {
    @NotBlank
    @URL
    
    private String companyProfileUrl;
    
}
