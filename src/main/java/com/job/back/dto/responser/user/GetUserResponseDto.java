package com.job.back.dto.responser.user;

import com.job.back.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
    //? user가 맞는지 구분하는 메서드
    private String userEmail;
    private String userPassword;
    private String userProfile;
    private String userTelNumber;
    private String userName;
    private String userAddress;
    private int userAge;
    private String userGender;

    public GetUserResponseDto(UserEntity userEntity) {
        this.userEmail = userEntity.getUserEmail();
        this.userPassword = userEntity.getUserPassword();
        this.userProfile = userEntity.getUserProfile();
        this.userTelNumber = userEntity.getUserTelNumber();
        this.userName = userEntity.getUserName();
        this.userAddress = userEntity.getUserAddress();
        this.userAge = userEntity.getUserAge();
        this.userGender = userEntity.getUserGender();
    }
    
}
