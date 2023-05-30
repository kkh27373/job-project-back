package com.job.back.dto.response.company;

import java.util.ArrayList;
import java.util.List;

import com.job.back.entity.CompanyEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "메인화면 회사목록 TOP3에서 회사목록 불러오기")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyTop3ListResponseDto {
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

    @ApiModelProperty(value = "회사 직원 수", example = "1000", required = false)
    private String companyEmployee;
    
    @ApiModelProperty(value = "회사 연 매출", example = "200000000", required = false)
    private String companyAnnualSales;
    
    public GetCompanyTop3ListResponseDto(CompanyEntity companyEntity) {
        this.companyTelNumber = companyEntity.getCompanyTelNumber();
        this.companyName = companyEntity.getCompanyName();
        this.companyProfileUrl = companyEntity.getCompanyProfileUrl();
        this.companyAddress = companyEntity.getCompanyAddress();
        this.companyCategory = companyEntity.getCompanyCategory();
        this.companyPassword = companyEntity.getCompanyPassword();
        this.companyEmployee = companyEntity.getCompanyEmployee();
        this.companyAnnualSales = companyEntity.getCompanyAnnualSales();
    }

    public static List<GetCompanyTop3ListResponseDto> copyList(List<CompanyEntity> companyEntitiesList) {
        List<GetCompanyTop3ListResponseDto> list = new ArrayList<>();

        for (CompanyEntity companyEntity: companyEntitiesList) {
            GetCompanyTop3ListResponseDto dto = new GetCompanyTop3ListResponseDto(companyEntity);
            list.add(dto);
        }
        return list;
    }
}
