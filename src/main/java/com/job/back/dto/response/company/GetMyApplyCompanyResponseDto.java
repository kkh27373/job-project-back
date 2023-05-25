package com.job.back.dto.response.company;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "지원자가 지원한 회사 리스트 불러오기 Response Body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMyApplyCompanyResponseDto {
    @ApiModelProperty(value = "회사 전화번호", example = "051-2222-2222", required = true)
    private String companyTelNumber;
    
    @ApiModelProperty(value = "회사 이름", example = "A회사", required = true)
    private String companyName;
    
    @ApiModelProperty(value = "회사 프로필 사진 URL", example = "https://~", required = true)
    private String companyProfileUrl;
    
    @ApiModelProperty(value = "회사 주소", example = "부산광역시 기장군", required = true)
    private String companyAddress;
    
    @ApiModelProperty(value = "회사 업종", example = "IT", required = true)
    private String companyCategory;
    
    @ApiModelProperty(value = "회사 비밀번호", example = "P!ssW0rd!", required = true)
    private String companyPassword;

    @ApiModelProperty(value = "해당 회사에 지원한 지원자의 점수", example = "100", required = true)
    private int applicantTotalScore;
   
    
}
