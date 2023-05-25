package com.job.back.dto.response.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "유저가 지원하고 싶은 회사 리스트 Response Body - data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserWishListResponseDto {

    @ApiModelProperty(value = "지원하고 싶은 회사의 내 총 점수", example = "70", required = true)
    private int wish_company_my_total_score;
    @ApiModelProperty(value = "지원하고 싶은 회사의 내 합격률", example = "80.0", required = true)
    private double wish_company_my_percentile;

}
