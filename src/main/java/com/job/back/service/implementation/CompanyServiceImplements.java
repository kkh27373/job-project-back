package com.job.back.service.implementation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.service.CompanyService;

public class CompanyServiceImplements implements CompanyService {

    @Override
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(String companyEmail,
            @Valid PatchCompanyProfileDto requestBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchCompanyProfile'");
    }

    @Override
    public ResponseDto<GetCompanyResponseDto> getCompany(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCompany'");
    }

    @Override
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(ValidateCompanyEmailDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateCompanyEmail'");
    }

    @Override
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(ValidateCompanyTelNumberDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateCompanyTelNumber'");
    }
}
