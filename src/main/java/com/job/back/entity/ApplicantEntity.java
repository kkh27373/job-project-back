package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.job.back.entity.Composite_Key.User_Company_PK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="Applicant" )
@Table(name = "Applicant")
// ! 복합 키 세팅을 위한 Annotation 추가 
@IdClass(User_Company_PK.class)
public class ApplicantEntity {
    
    @Id
    // 지원자 이메일
    private String applicantUserEmail;
    @Id
    // 지원자가 지원할 회사 전화번호
    private String applicantCompanyTelNumber;
    // 지원자 최종 학력
    private String applicantFinalEducation;
    // 지원자 경력
    private String applicantCarrer;
    // 지원자 자격증
    private String applicantLicense;
    // 지원자 최종 점수
    private int applicantTotalScore;
}