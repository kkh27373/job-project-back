package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.service.CompanyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "회사 모듈")
@RestController
@RequestMapping(ApiPattern.COMPANY)
public class CompanyController {

    @Autowired private CompanyService companyService;

    private final String GET_COMPANY = "/";
    private final String VALIDATE_COMPANY_EMAIL = "validte/company-email";
    private final String VALIDATE_COMPANY_TEL_NUMBER = "validte/company-tel-number";

    @ApiOperation(value = "회사 정보 불러오기")
    @GetMapping(GET_COMPANY)
    public ResponseDto<GetCompanyResponseDto> getCompany(@AuthenticationPrincipal String companyTelNumber) {
        ResponseDto<GetCompanyResponseDto> response = companyService.getCompany(companyTelNumber);
        return response;
    }
    @ApiOperation(value = "회사 이메일 중복 체크")
    @GetMapping(VALIDATE_COMPANY_EMAIL)
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(@Valid @RequestBody ValidateCompanyEmailDto requsetBody) {
        ResponseDto<ValidateCompanyEmailResponseDto> response = companyService.validateCompanyEmail(requsetBody);
        return response;
    }
    @ApiOperation(value = "회사 전화번호 중복 체크")
    @GetMapping(VALIDATE_COMPANY_TEL_NUMBER)
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(@Valid @RequestBody ValidateCompanyTelNumberDto requsetBody) {
        ResponseDto<ValidateCompanyTelNumberResponseDto> response = companyService.validateCompanyTelNumber(requsetBody);
        return response;
    }
}
