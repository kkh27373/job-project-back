package com.job.back.dto.response.user;

import com.job.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserProfileResponseDto {
    
    private String userEmail;
    private String userPassword;
    private String userProfileUrl;
    private String userTelNumber;
    private String userName;
    private String userAddress;
    private int userAge;
    private String userGender;

    public PatchUserProfileResponseDto(UserEntity userEntity) {
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
