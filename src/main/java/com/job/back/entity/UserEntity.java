package com.job.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.dto.User_Select_Component_Dto;
import com.job.back.dto.request.auth.UserSignUpDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
    @Id
    @Column(name="user_email")
    private String userEmail;
    private String userPassword;
    private String userProfileUrl;
    private String userTelNumber;
    private String userName;
    private String userAddress;
    private int userAge;
    private String userGender;
    private String[] userFinalEducation;
    private String[] userCarrer;
    private String[] userLicense;
    
    public UserEntity(UserSignUpDto dto){
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
        this.userProfileUrl = dto.getUserProfileUrl();
        this.userTelNumber = dto.getUserTelNumber();
        this.userName = dto.getUserName();
        this.userAddress = dto.getUserAddress();
        this.userAge = dto.getUserAge();
        this.userGender = dto.getUserGender();
    }

    // ! User 필드 중에서 나중에 회원가입시 필수 입력사항이 아니고 나중에 수정가능한 필드들에 대한 생성자 
    public UserEntity(User_Select_Component_Dto dto){
        this.userFinalEducation  = dto.getUserFinalEducation();
        this.userCarrer = dto.getUserCarrer();
        this.userLicense = dto.getUserLicense();
    }
}