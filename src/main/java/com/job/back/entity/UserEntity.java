package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private String userEmail;
    private String userPassword;
    private String userProfile;
    private String userTelNumber;
    private String userName;
    private String userAddress;
    private int userAge;
    private String userGender;
    private String userFinalEducation;
    private String userCarrer;
    private String userLicense;
    
}