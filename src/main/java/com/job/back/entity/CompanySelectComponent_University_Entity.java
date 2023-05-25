package com.job.back.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.job.back.common.util.DatabaseJson;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "Company_University_Select_Component")
@Table(name = "Company_University_Select_Component")
public class CompanySelectComponent_University_Entity {
    
    @Id
    private String companyTelNumber;
    

   
    private String first_grade_university;
    private int first_grade_university_score;

    
    private String second_grade_university;
    private int second_grade_university_score;

    
    private String third_grade_university;
    private int third_grade_university_score;

    
    private String etc_grade_university;
    private int etc_grade_university_score;

    

    public CompanySelectComponent_University_Entity(String companyTelNumber,
                                        String[] first_grade_university,int first_grade_university_score,
                                        String[] second_grade_university,int second_grade_university_score,
                                        String[] third_grade_university, int third_grade_university_score,
                                        String[] etc_grade_university,int etc_grade_university_score){

                                            
                                            this.companyTelNumber = companyTelNumber;
                                            this.first_grade_university = DatabaseJson.arrayToString(first_grade_university);
                                            this.first_grade_university_score = first_grade_university_score;
                                            this.second_grade_university = DatabaseJson.arrayToString(second_grade_university);
                                            this.second_grade_university_score = second_grade_university_score;
                                            this.third_grade_university = DatabaseJson.arrayToString(third_grade_university);
                                            this.third_grade_university_score = third_grade_university_score;
                                            this.etc_grade_university = DatabaseJson.arrayToString(etc_grade_university);
                                            this.etc_grade_university_score = etc_grade_university_score;


    }


}
