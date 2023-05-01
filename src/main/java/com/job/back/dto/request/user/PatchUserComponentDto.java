package com.job.back.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserComponentDto {
    @NotBlank
    private String userFinalEducation;
    @NotBlank
    private String userCarrer;
    @NotBlank
    private String userLicense;

}
