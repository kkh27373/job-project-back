package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.request.company.GetCompanyListMainDto;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyListMainResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.service.implementation.CompanyServiceImplements;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "회사 모듈")
@RestController
@RequestMapping(ApiPattern.COMPANY)
public class CompanyController {
    @Autowired private CompanyServiceImplements companyService;

    private final String GET_COMPANY = "/";
    private final String VALIDATE_COMPANY_EMAIL = "/validate/companyEmail";
    private final String VALIDATE_COMPANY_TEL_NUMBER = "/validate/companyTelNumber";
<<<<<<< HEAD
    private final String PATCH_COMPANY_PROFILE = "/validate/companyProfile";

    @PostMapping(GET_COMPANY)
=======
    private final String PATCH_COMPANY_PROFILE = "/patch/companyProfile";
    private final String Main_list_company_info = "/list";

    @GetMapping(GET_COMPANY)
>>>>>>> 424c6f6887fd9fc748b41ef981350e7c88e80460
    public ResponseDto<GetCompanyResponseDto> getCompany(@AuthenticationPrincipal String companyEmail){
        ResponseDto<GetCompanyResponseDto> response = companyService.getCompany(companyEmail);
        return response;
    }

<<<<<<< HEAD
=======
    
>>>>>>> 424c6f6887fd9fc748b41ef981350e7c88e80460
    @PostMapping(VALIDATE_COMPANY_EMAIL)
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(@Valid @RequestBody ValidateCompanyEmailDto requestBody){
        ResponseDto<ValidateCompanyEmailResponseDto> response = companyService.validateCompanyEmail(requestBody);
        return response;
    }

    @PostMapping(VALIDATE_COMPANY_TEL_NUMBER)
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(@Valid @RequestBody ValidateCompanyTelNumberDto requestBody){
        ResponseDto<ValidateCompanyTelNumberResponseDto> response = companyService.validateCompanyTelNumber(requestBody);
        return response;
    }

    @PostMapping(PATCH_COMPANY_PROFILE)
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(@Valid @RequestBody PatchCompanyProfileDto requestBody){
        ResponseDto<PatchCompanyProfileResponseDto> response = companyService.patchCompanyProfile(requestBody);
        return response;

    }

    @GetMapping(Main_list_company_info)
    public ResponseDto<GetCompanyListMainResponseDto> getCompanyListMain(@AuthenticationPrincipal String companyEmail){
        ResponseDto<GetCompanyListMainResponseDto> response  = companyService.getCompanyListMain(companyEmail);
        return response;

    }


    



    

}
