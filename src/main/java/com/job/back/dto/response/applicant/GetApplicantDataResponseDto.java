package com.job.back.dto.response.applicant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "지원자 정보 불러오기 response body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetApplicantDataResponseDto {
    
    @ApiModelProperty(value = "유저 이메일", example = "userEmail@user.com", required = true)
    private String userEmail;
    @ApiModelProperty(value = "지원자 최종학력", example = "대졸", required = true)
    private String applicant_FinalEducation;
    @ApiModelProperty(value = "지원자 경력", example = "5년", required = true)
    private String applicant_Carrer;
    @ApiModelProperty(value = "지원자 자격증", example = "컴활 2급", required = true)
    private String applicant_License;
    


    
}
