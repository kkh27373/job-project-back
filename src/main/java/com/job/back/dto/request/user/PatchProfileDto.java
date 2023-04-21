package com.job.back.dto.request.user;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchProfileDto {
    @NotBlank
    @URL
    private String userProfileUrl;
}
