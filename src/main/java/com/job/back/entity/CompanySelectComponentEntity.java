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

    // json type
    //{"userFinalEducationGradeOne"}

    
    @JsonProperty("서울대학교")
    public int gradeOne() {
        return userFinalEducationGradeOne;
    }

    @JsonProperty("연세대학교")
    public int gradeTwo() {
        return userFinalEducationGradeOne;
    }

    @JsonProperty("고려대학교")
    public int gradeThree() {   
        return userFinalEducationGradeOne;
    }

    
    
}
