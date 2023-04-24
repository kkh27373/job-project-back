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
    // 회사 전화번호
    private String companyTelNumber;
    // 최종 학력 1 (대졸,박사 학위,석사 학위,고졸)
    private int userFinalEducationGradeOne;
    // 최종 학력 2 ( 전공 과목 )
    private int userFinalEducationGradeTwo;
    // 최종 학력 3 (최종학교 명)
    private int userFinalEducationGradeThree;
    // 최종 학력 점수
    private int userFinalEducationGradeEtc;
    // 경력
    private int userCareerGradeOne;
    // 자격증
    private int userLiceseGradeOne;

    @JsonProperty("1순위 대학교")
    public String[] first_grade_university;

    @JsonProperty("2순위 대학교")
    public String[] second_grade_university;

    @JsonProperty("3순위 대학교")
    public String[] third_grade_university;

    
    
}
