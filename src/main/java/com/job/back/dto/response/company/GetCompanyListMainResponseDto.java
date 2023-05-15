package com.job.back.dto.response.company;

import java.util.List;

import com.job.back.entity.CompanyEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCompanyListMainResponseDto {

    private List<CompanyEntity> companyentity;

    
    
}
