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
    private String userEmail;
    private String license;
    private String companyName;
    private String finalEducation;
    private String carrer;
    private String desireCategory;
    private String totalScore;
}