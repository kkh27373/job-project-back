package com.job.back.dto.response.company;

import java.util.List;

import com.job.back.entity.ApplicantEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUpApplicantResponseDto {

    private List<ApplicantEntity> applicant_Email; 
    
}
