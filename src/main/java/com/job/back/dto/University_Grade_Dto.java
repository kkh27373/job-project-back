package com.job.back.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class University_Grade_Dto {

    private  String companyTelNumber;
    private  String[] first_grade_university;
    private  int first_grade_university_score;
    private  String[] second_grade_university;
    private  int second_grade_university_score;
    private  String[] third_grade_university;
    private  int third_grade_university_score;
    private  String[] etc_grade_university;
    private  int etc_grade_university_score;
    
}
