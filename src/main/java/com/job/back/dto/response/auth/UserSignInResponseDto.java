package com.job.back.dto.response.auth;

import com.job.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInResponseDto {
    // 이메일일
    private String userEmail;
    // 패스워드
    private String userPassword;
    // 프로필
    private String userProfileUrl;
    // 전화번호
    private String userTelNumber;
    //이름
    private String userName;
    // 주소
    private String userAddress;
    //나이
    private int userAge;
    //성별
    private String userGender;
    //로그인시 받을 토큰
    private String token;
    // 토큰 만료기간
    private int expiredTime;

    public UserSignInResponseDto(UserEntity userEntity, String token) {
        this.userEmail = userEntity.getUserEmail();
        this.userPassword = userEntity.getUserPassword();
        this.userProfileUrl = userEntity.getUserProfileUrl();
        this.userTelNumber = userEntity.getUserTelNumber();
        this.userName = userEntity.getUserName();
        this.userAddress = userEntity.getUserAddress();
        this.userAge = userEntity.getUserAge();
        this.token = token;
        this.expiredTime = 3600000;
    }
}
