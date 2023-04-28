package com.job.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class University_Grade_Dto {

    public  String companyTelNumber;
    public  String[] first_grade_university;
    public  int first_grade_university_score;
    public  String[] second_grade_university;
    public  int second_grade_university_score;
    public  String[] third_grade_university;
    public  int third_grade_university_score;
    public  String[] etc_grade_university;
    public  int etc_grade_university_score;
    
}
