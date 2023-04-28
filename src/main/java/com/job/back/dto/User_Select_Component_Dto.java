package com.job.back.dto;

import javax.persistence.Id;

import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.UserSelectComponentEntity;

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

    public User_Select_Component_Dto(UserSelectComponentEntity userselectcomponententity){

        this.userEmail = userselectcomponententity.getUserUserEmail();
        this.userFinalEducation = DatabaseJson.stringToArray(userselectcomponententity.getUserFinalEducation());
        this.userCarrer = DatabaseJson.stringToArray(userselectcomponententity.getUserCarrer());
        this.userLicense = DatabaseJson.stringToArray(userselectcomponententity.getUserLicense());


    }
    
}
