package com.job.back.dto.response.company;


import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.CompanySelectComponent_University_Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectUniversityResponseDto {
    
    private String companyTelNumber;

    private String[] first_grade_university;
    private int first_grade_score;

    private String[] second_grade_university;
    private int second_grade_score;

    private String[] third_grade_university;
    private int third_grade_score;

    private String[] etc_grade_university;
    private int etc_grade_score;



    public SelectUniversityResponseDto(CompanySelectComponent_University_Entity companyselectcomponentuniversityentity){

        this.companyTelNumber = companyselectcomponentuniversityentity.getCompanyTelNumber();
        this.first_grade_university = DatabaseJson.stringToArray(companyselectcomponentuniversityentity.getFirst_grade_university());
        this.first_grade_score = companyselectcomponentuniversityentity.getFirst_grade_university_score();
        this.second_grade_university = DatabaseJson.stringToArray(companyselectcomponentuniversityentity.getSecond_grade_university());
        this.second_grade_score = companyselectcomponentuniversityentity.getSecond_grade_university_score();
        this.third_grade_university = DatabaseJson.stringToArray(companyselectcomponentuniversityentity.getThird_grade_university());
        this.third_grade_score = companyselectcomponentuniversityentity.getThird_grade_university_score();
        this.etc_grade_university = DatabaseJson.stringToArray(companyselectcomponentuniversityentity.getEtc_grade_university());
        this.etc_grade_score = companyselectcomponentuniversityentity.getEtc_grade_university_score();


    }
    

    
}
