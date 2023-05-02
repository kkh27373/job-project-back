package com.job.back.dto.response.applicant;

import com.job.back.entity.ApplicantEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantScoreResponseDto {

    private int applicant_total_score;


    public ApplicantScoreResponseDto(ApplicantEntity applicantEntity){

        this.applicant_total_score = applicantEntity.getApplicantTotalScore();

    }
    
}
