package com.job.back.service.implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.job.back.common.constant.ResponseMessage;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.entity.CompanyEntity;
import com.job.back.repository.CompanyReposiotry;
import com.job.back.service.CompanyService;

@Service
public class CompanyServiceImplements implements CompanyService {
    @Autowired private CompanyReposiotry companyReposiotry;

    @Override
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(String companyEmail,
            @Valid PatchCompanyProfileDto requestBody) {
        return null;
    }

    @Override
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(ValidateCompanyEmailDto dto) {
        ValidateCompanyEmailResponseDto data = null;

        String companyEmail = dto.getCompanyEmail();

        try {
            boolean hasEmail = companyReposiotry.existsByCompanyEmail(companyEmail);
            data = new ValidateCompanyEmailResponseDto(!hasEmail);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }

    @Override
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(ValidateCompanyTelNumberDto dto) {
        ValidateCompanyTelNumberResponseDto data = null;

        String companyTelNumber = dto.getCompanyTelNumber();

        try {
            boolean hasTelNumber = companyReposiotry.existsByCompanyTelNumber(companyTelNumber);
            data = new ValidateCompanyTelNumberResponseDto(!hasTelNumber);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
        
    }
    
    @Override
    public ResponseDto<GetCompanyResponseDto> getCompany(String companyEmail) {
        GetCompanyResponseDto data = null;
        
        try {
            CompanyEntity companyEntity = companyReposiotry.findByCompanyEmail(companyEmail);
            if(companyEntity == null) return ResponseDto.setFailed(ResponseMessage.NOT_EXIST_COMPANY);

            data = new GetCompanyResponseDto(companyEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }

        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);

    }
}
