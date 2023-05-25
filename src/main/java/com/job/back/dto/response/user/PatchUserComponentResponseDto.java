package com.job.back.dto.response.user;

import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "유저 정보 추가 response body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserComponentResponseDto {
    @ApiModelProperty(value = "유저 이메일", example = "userEmail@user.com", required = true)
    private String userEmail;
    @ApiModelProperty(value = "유저 최종학력", example = "대졸", required = true)
    private String[] userFinalEducation;
    @ApiModelProperty(value = "유저 경력", example = "5년", required = true)
    private String[] userCarrer;
    @ApiModelProperty(value = "유저 자격증", example = "컴활 2급", required = true)
    private String[] userLicense;

    public PatchUserComponentResponseDto(UserEntity userEntity) {
        this.userFinalEducation = DatabaseJson.stringToArray(userEntity.getUserFinalEducation());
        this.userCarrer = DatabaseJson.stringToArray(userEntity.getUserCarrer());
        this.userLicense = DatabaseJson.stringToArray(userEntity.getUserLicense());
        this.userEmail = userEntity.getUserEmail();
    }
}
