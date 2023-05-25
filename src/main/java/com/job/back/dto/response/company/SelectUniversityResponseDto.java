package com.job.back.dto.response.company;


import com.job.back.common.util.DatabaseJson;
import com.job.back.entity.CompanySelectComponent_University_Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사가 요구하는 지원자의 학력 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SelectUniversityResponseDto {
    
    @ApiModelProperty(value = "회사 번호", example = "051-2222-2222", required = true)
    private String companyTelNumber;


    @ApiModelProperty(value = "1급 학교", example = "서울대", required = true)
    private String[] first_grade_university;
    @ApiModelProperty(value = "1급 학교 점수", example = "40", required = true)
    private int first_grade_score;

    @ApiModelProperty(value = "2급 학교", example = "부산대", required = true)
    private String[] second_grade_university;
    @ApiModelProperty(value = "2급 학교 점수", example = "30", required = true)
    private int second_grade_score;

    @ApiModelProperty(value = "3급 학교", example = "경남대", required = true)
    private String[] third_grade_university;
    @ApiModelProperty(value = "3급 학교 점수", example = "20", required = true)
    private int third_grade_score;

    @ApiModelProperty(value = "기타 학교", example = "~~대", required = true)
    private String[] etc_grade_university;
    @ApiModelProperty(value = "기타 학교 점수", example = "15", required = true)
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
