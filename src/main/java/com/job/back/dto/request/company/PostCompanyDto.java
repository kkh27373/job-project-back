package com.job.back.dto.request.company;

import javax.validation.constraints.NotBlank;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCompanyDto {

    @NotBlank
    private String companyCategory;

    @NotBlank
    private String companyHomePage;

    @NotBlank
    private int companyEmployeeNumber;

    @NotBlank
    private int companySales;

}
