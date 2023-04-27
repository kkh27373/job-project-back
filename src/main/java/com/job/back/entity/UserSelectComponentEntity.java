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
@Entity(name = "User_Selet_Component")
@Table(name = "User_Selet_Component")
public class UserSelectComponentEntity {
    @Id
    private String userUserEmail;
    private String userFinalEducation;
    private String userCarrer;
    private String userLicense;
}
