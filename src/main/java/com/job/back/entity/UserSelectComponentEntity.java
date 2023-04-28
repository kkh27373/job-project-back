package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.job.back.common.util.DatabaseJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User_Selet_Component")
@Table(name = "User_Selet_Component")
public class UserSelectComponentEntity {
    @Id
    private String userUserEmail;
    private String userFinalEducation;
    private String userCarrer;
    private String userLicense;

    public UserSelectComponentEntity(String userEmail,String[] userFinalEducation,String[] userCarrer,String[] userLicense){
        this.userUserEmail = userEmail;
        this.userFinalEducation = DatabaseJson.arrayToString(userFinalEducation);
        this.userCarrer = DatabaseJson.arrayToString(userCarrer);
        this.userLicense = DatabaseJson.arrayToString(userLicense);
    }


}
