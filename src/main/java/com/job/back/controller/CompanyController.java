package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;

import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.service.implementation.CompanyServiceImplements;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "회사 모듈")
public class CompanyController {
    @Autowired private CompanyServiceImplements companyService;

    private final String GET_COMPANY = "/";
    private final String VALIDATE_COMPANY_EMAIL = "validate/company-email";
    private final String VALIDATE_COMPANY_TEL_NUMBER = "validate/company-tel-number";
    private final String PATCH_COMPANY_PROFILE = "validate/company-profile";

    @ApiOperation(GET_COMPANY)
    public ResponseDto<GetCompanyResponseDto> getCompany(@AuthenticationPrincipal String companyEmail){
        ResponseDto<GetCompanyResponseDto> response = companyService.getCompany(companyEmail);
        return response;
    }

    @ApiOperation(VALIDATE_COMPANY_EMAIL)
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(@Valid @RequestBody ValidateCompanyEmailDto requestBody){
        ResponseDto<ValidateCompanyEmailResponseDto> response = companyService.validateCompanyEmail(requestBody);
        return response;
    }

    @ApiOperation(VALIDATE_COMPANY_TEL_NUMBER)
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(@Valid @RequestBody ValidateCompanyTelNumberDto requestBody){
        ResponseDto<ValidateCompanyTelNumberResponseDto> response = companyService.validateCompanyTelNumber(requestBody);
        return response;
    }

    @ApiOperation(PATCH_COMPANY_PROFILE)
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(
        @ApiParam(hidden = true)
        @AuthenticationPrincipal String companyEmail,
        @Valid @RequestBody PatchCompanyProfileDto requestBody
    ){
        ResponseDto<PatchCompanyProfileResponseDto> response = companyService.patchCompanyProfile(companyEmail, requestBody);
        return response;
    }

}
