package com.job.back.dto.response.applicant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "지원자 합격률 response body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantPercentileResponseDto {
    @ApiModelProperty(value = "지원자 합격률", example = "80.0", required = true)
    private double applicant_percentile;
    
}
