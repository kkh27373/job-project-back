package com.job.back.dto.response.applicant;

import com.job.back.entity.ApplicantEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "지원자 점수 response body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantScoreResponseDto {

    @ApiModelProperty(value = "지원자 학력 점수", example = "20", required = true)
    private int applicant_university_score;
    @ApiModelProperty(value = "지원자 경력 점수", example = "20", required = true)
    private int applicant_carrer_score;
    @ApiModelProperty(value = "지원자 자격증 점수", example = "20", required = true)
    private int applicant_license_score;

    @ApiModelProperty(value = "지원자 최종 점수", example = "60", required = true)
    private int applicant_total_score;

    



    
    
}
