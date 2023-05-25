package com.job.back.dto.response.user;

import com.job.back.entity.UserEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "유저 불러오기")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    @ApiModelProperty(value = "유저 이메일", example = "userEmail@user.com", required = true)
    private String userEmail;
    @ApiModelProperty(value = "유저 비밀번호", example = "P!ssW0rd!", required = true)
    private String userPassword;
    @ApiModelProperty(value = "유저 프로필 이미지 URL", example = "http://~", required = true)
    private String userProfileUrl;
    @ApiModelProperty(value = "유저 전화번호", example = "010-2222-2222", required = true)
    private String userTelNumber;
    @ApiModelProperty(value = "유저 이름", example = "홍길동", required = true)
    private String userName;
    @ApiModelProperty(value = "유저 주소", example = "부산광역시 기장군", required = true)
    private String userAddress;
    @ApiModelProperty(value = "유저 나이", example = "20", required = true)
    private int userAge;
    @ApiModelProperty(value = "유저 성별", example = "남", required = true)
    private String userGender;

    public GetUserResponseDto(UserEntity userEntity) {
        this.userEmail = userEntity.getUserEmail();
        this.userPassword = userEntity.getUserPassword();
        this.userProfileUrl = userEntity.getUserProfileUrl();
        this.userTelNumber = userEntity.getUserTelNumber();
        this.userName = userEntity.getUserName();
        this.userAddress = userEntity.getUserAddress();
        this.userAge = userEntity.getUserAge();
        this.userGender = userEntity.getUserGender();
    }
    
}
