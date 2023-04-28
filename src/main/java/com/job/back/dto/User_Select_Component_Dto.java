package com.job.back.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Select_Component_Dto {

    @Id
    private String userEmail;
    private String[] userFinalEducation;
    private String[] userCarrer;
    private String[] userLicense;
    
}
