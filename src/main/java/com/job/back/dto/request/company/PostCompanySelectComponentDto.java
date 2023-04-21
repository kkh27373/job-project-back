package com.job.back.dto.request.company;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCompanySelectComponentDto {

    @NotBlank
    private String userFinalEducationGradeOne;
    @NotBlank
    private String userFinalEducationGradeTwo;
    @NotBlank
    private String userFinalEducationGradeThree;
    @NotBlank
    private String userCareerGradeOne;
    @NotBlank
    private String userLicenseGradeOne;
    
}
