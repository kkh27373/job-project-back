package com.job.back.entity.Composite_Key;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class User_Wish_List_PK implements Serializable{

    @Column(name = "wish_company_tel_number")
    private String wish_company_tel_number;
    @Column(name = "wish_user_email")
    private String wish_user_email;
    
}
