package com.job.back.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.job.back.dto.response.company.GetRelatedSearchWordResponseDto;
import com.job.back.dto.response.company.GetSearchListResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;
import com.job.back.service.CompanyService;
import com.job.back.service.implementation.CompanyServiceImplements;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description = "회사 모듈")
@RestController
@RequestMapping(ApiPattern.COMPANY)
public class CompanyController {
    @Autowired private CompanyService companyService;

    private final String GET_COMPANY = "/";
    private final String VALIDATE_COMPANY_EMAIL = "/validate/companyEmail";
    private final String VALIDATE_COMPANY_TEL_NUMBER = "/validate/companyTelNumber";
    private final String PATCH_COMPANY_PROFILE = "/patch/companyProfile";
    private final String Main_list_company_info = "/list";
    private final String GET_SEARCH_LIST = "/search-list/{searchWord}";
    private final String GET_SEARCH_LIST_PREVIOUS = "/search-list/{searchWord}/{previousSearchWord}";
    private final String GET_RELATED_SEARCH_WORD = "/related-search-word/{searchWord}";

    @GetMapping(GET_COMPANY)
    public ResponseDto<GetCompanyResponseDto> getCompany(@AuthenticationPrincipal String companyEmail){
        ResponseDto<GetCompanyResponseDto> response = companyService.getCompany(companyEmail);
        return response;
    }

    
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
    public ResponseDto<GetCompanyListMainResponseDto[]> getCompanyListMain(@AuthenticationPrincipal String companyEmail){
        ResponseDto<GetCompanyListMainResponseDto[]> response  = companyService.getCompanyListMain(companyEmail);
        return response;

    }

    @GetMapping(value = {GET_SEARCH_LIST, GET_SEARCH_LIST_PREVIOUS})
    public ResponseDto<List<GetSearchListResponseDto>> getSearchList(
        @PathVariable("searchWord") String searchWord,
        @PathVariable(name = "previousSearchWord", required = false) String previousSearchWord
    ){
        ResponseDto<List<GetSearchListResponseDto>> response = companyService.getSearchList(searchWord, previousSearchWord);
        return response;
    }

    @GetMapping(GET_RELATED_SEARCH_WORD)
    public ResponseDto<GetRelatedSearchWordResponseDto> getRelatedSearchWord(@PathVariable("searchWord") String searchWord){
        ResponseDto<GetRelatedSearchWordResponseDto> response = companyService.getRelatedSearchWord(searchWord);
        return response;
    }



    



    

}
