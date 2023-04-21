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
    private String applicantUserEmail;
    private String applicantLicense;
    private String applicantCompanyName;
    private String applicantFinalEducation;
    private String applicantCarrer;
    private String applicantDesireCategory;
    private String applicantTotalScore;
}