package com.job.back.dto.response.user;

import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserComponentResponseDto {
    private String userEmail;
    private String[] userFinalEducation;
    private String[] userCarrer;
    private String[] userLicense;

    public PatchUserComponentResponseDto(UserEntity userEntity) {
        this.userFinalEducation = DatabaseJson.stringToArray(userEntity.getUserFinalEducation());
        this.userCarrer = DatabaseJson.stringToArray(userEntity.getUserCarrer());
        this.userLicense = DatabaseJson.stringToArray(userEntity.getUserLicense());
        this.userEmail = userEntity.getUserEmail();
    }
}
