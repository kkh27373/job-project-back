package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CompanySelectComponent")
@Table(name = "CompanySelectComponent")
public class CompanySelectComponentEntity {
    private String companyTelNumber;
    private int userFinalEducationGradeOne;
    private int userFinalEducationGradeTwo;
    private int userFinalEducationGradeThree;
    private int userFinalEducationGradeEtc;
    private int userCareerGradeOne;
    private int userLiceseGradeOne;

    @JsonProperty("1순위 대학교")
    public String[] first_grade_university;

    @JsonProperty("2순위 대학교")
    public String[] second_grade_university;

    @JsonProperty("3순위 대학교")
    public String[] third_grade_university;

    
    
}
