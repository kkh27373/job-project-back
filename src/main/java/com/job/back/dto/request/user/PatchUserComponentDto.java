package com.job.back.dto.request.user;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchUserComponentDto {
    @NotBlank
    private String userFinalEducation;
    @NotBlank
    private String userCarrer;
    @NotBlank
    private String userLicense;
}
