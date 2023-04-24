package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Id
    private String companyTelNumber;
    private int userCareerGradeOne;
    private int userLicenseGradeOne;

    @JsonProperty("1순위 대학교")
    public String[] first_grade_university;

    @JsonProperty("2순위 대학교")
    public String[] second_grade_university;

    @JsonProperty("3순위 대학교")
    public String[] third_grade_university;

    @JsonProperty("기타 순위 대학교")
    public String[] etc_grade_university;

    public CompanySelectComponentEntity(String[] first_grade_university,String[] second_grade_university,String[] third_grade_university, String[] etc_grade_university){
        
    }

    
    
}
