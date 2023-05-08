package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.job.back.entity.Composite_Key.User_Wish_List_PK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_wish_list")
@Table(name = "user_wish_list")
@IdClass(User_Wish_List_PK.class)
public class UserWishListEntity {
    @Id
    private String wish_company_tel_number;
    @Id
    private String wish_user_email;
    private String wish_company_my_total_score;
    private String wish_company_my_percentile;
    
}
