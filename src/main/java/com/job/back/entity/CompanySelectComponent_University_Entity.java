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
@Entity(name = "Company_University_Select_Component")
@Table(name = "Company_University_Select_Component")
public class CompanySelectComponent_University_Entity {
    @Id
    private String companyTelNumber;
    

    @JsonProperty("1순위 대학교")
    public String[] first_grade_university;
    @JsonProperty("1순위 대학교 점수")
    public int first_grade_score;

    @JsonProperty("2순위 대학교")
    public String[] second_grade_university;
    @JsonProperty("2순위 대학교 점수")
    public int second_grade_score;

    @JsonProperty("3순위 대학교")
    public String[] third_grade_university;
    @JsonProperty("3순위 대학교 점수")
    public int third_grade_score;

    @JsonProperty("기타 순위 대학교")
    public String[] etc_grade_university;
    @JsonProperty("기타순위 대학교 점수")
    public int etc_grade_score;

    

    public CompanySelectComponent_University_Entity(String[] first_grade_university,int first_grade_score,
                                        String[] second_grade_university,int second_grade_score,
                                        String[] third_grade_university, int third_grade_score,
                                        String[] etc_grade_university,int etc_grade_score){


    }

    
    
}
