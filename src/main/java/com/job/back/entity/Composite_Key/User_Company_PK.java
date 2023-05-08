package com.job.back.entity.Composite_Key;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.Data;

@Data
public class User_Company_PK implements Serializable{

    @Column(name = "applicant_user_email")
    // 지원자 이메일
    private String applicantUserEmail;
    @Column(name = "applicant_company_tel_number")
    // 지원자가 지원할 회사 전화번호
    private String applicantCompanyTelNumber;
    
}
