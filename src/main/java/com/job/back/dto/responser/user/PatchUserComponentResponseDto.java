package com.job.back.dto.responser.user;

import com.job.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserComponentResponseDto {
    private String userFinalEducation;
    private String userCarrer;
    private String userLicense;

    public PatchUserComponentResponseDto(UserEntity userEntity) {
        this.userFinalEducation = userEntity.getUserFinalEducation();
        this.userCarrer = userEntity.getUserCarrer();
        this.userLicense = userEntity.getUserLicense();
    }
}
