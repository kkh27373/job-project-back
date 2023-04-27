package com.job.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}