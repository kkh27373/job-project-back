package com.job.back.dto.response.user;

import com.job.back.entity.UserEntity;
import com.job.back.entity.UserSelectComponentEntity;

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

    public PatchUserComponentResponseDto(UserSelectComponentEntity userSelectComponentEntity) {
        this.userFinalEducation = userSelectComponentEntity.getUserFinalEducation();
        this.userCarrer = userSelectComponentEntity.getUserCarrer();
        this.userLicense = userSelectComponentEntity.getUserLicense();
    }
}
