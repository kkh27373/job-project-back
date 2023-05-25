package com.job.back.dto.response.company;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import com.job.back.entity.CompanyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "회사 검색 결과 목록 Response Body - data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetSearchListResponseDto {

    @Id
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
    
    @ApiModelProperty(value = "회사 이메일", example = "CompanyEmail@company.com", required = true)
    private String companyEmail;

    public GetSearchListResponseDto(CompanyEntity companyEntity){
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyPassword = companyEntity.getCompanyPassword();
        this.companyEmail = companyEntity.getCompanyEmail();
        this.companyCategory = companyEntity.getCompanyCategory();
    }

    public static List<GetSearchListResponseDto> copyList(List<CompanyEntity> companyEntityList){
        List<GetSearchListResponseDto> list = new ArrayList<>();

        for(CompanyEntity companyEntity : companyEntityList){
            GetSearchListResponseDto dto = new GetSearchListResponseDto(companyEntity);
            list.add(dto);
        }

        return list;
    }
}
