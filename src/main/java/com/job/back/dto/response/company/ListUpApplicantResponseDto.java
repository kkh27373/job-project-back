package com.job.back.dto.response.company;

import java.util.List;

import com.job.back.entity.ApplicantEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "지원자 리스트")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListUpApplicantResponseDto {

    @ApiModelProperty(value = "지원자 엔티티중 지원자 이메일 리스트 불러오기", example = "email", required = true)
    private List<ApplicantEntity> applicant_Email; 
    
}
