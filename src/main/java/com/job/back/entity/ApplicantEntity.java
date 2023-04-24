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
@Entity(name ="Applicant" )
@Table(name = "Applicant")
public class ApplicantEntity {
    @Id
    // 지원자 이메일
    private String applicantUserEmail;
    // 지원자 자격증
    private String applicantLicense;
    // 지원자가 지원할 회사 이름
    private String applicantCompanyName;
    // 지원자 최종 학력
    private String applicantFinalEducation;
    // 지원자 경력
    private String applicantCarrer;
    // 지원자 지원할 분야
    private String applicantDesireCategory;
    // 지원자 최종 점수
    private String applicantTotalScore;
}