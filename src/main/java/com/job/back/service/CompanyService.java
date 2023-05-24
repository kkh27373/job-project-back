package com.job.back.service;

import java.util.List;

import javax.validation.Valid;

import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.company.ValidateCompanyEmailDto;
import com.job.back.dto.request.company.ValidateCompanyTelNumberDto;
import com.job.back.dto.request.company.CompanyAdditionalInfoDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.company.GetCompanyListMainResponseDto;
import com.job.back.dto.response.company.GetCompanyPageResponseDto;
import com.job.back.dto.response.company.GetCompanyResponseDto;
import com.job.back.dto.response.company.GetCompanyTop3ListResponseDto;
import com.job.back.dto.response.company.CompanyInfoResponseDto;
import com.job.back.dto.response.company.ListUpApplicantResponseDto;
import com.job.back.dto.response.company.PatchCompanyProfileResponseDto;
import com.job.back.dto.response.company.ValidateCompanyEmailResponseDto;
import com.job.back.dto.response.company.ValidateCompanyTelNumberResponseDto;

public interface CompanyService {
    public ResponseDto<GetCompanyResponseDto> getCompany(String email);
    public ResponseDto<ValidateCompanyEmailResponseDto> validateCompanyEmail(ValidateCompanyEmailDto dto);
    public ResponseDto<ValidateCompanyTelNumberResponseDto> validateCompanyTelNumber(ValidateCompanyTelNumberDto dto);
    public ResponseDto<ListUpApplicantResponseDto> ListUpApplicant(String companyTelNumber);
    public ResponseDto<PatchCompanyProfileResponseDto> patchCompanyProfile(String companyEmail, PatchCompanyProfileDto dto);
    public ResponseDto<GetCompanyListMainResponseDto[]> getCompanyListMain(String companyEmail);
    public ResponseDto<GetCompanyTop3ListResponseDto[]> getTop3CompanyList(String companyEmail);
    public ResponseDto<CompanyInfoResponseDto> insertCompanyAdditionalInfo( CompanyAdditionalInfoDto requestBody);
    // public ResponseDto<CompanyInfoResponseDto> updateCompanyInfo(CompanyAdditionalInfoDto requestBody);
    // public ResponseDto<GetCompanyInfoResponseDto> getComapnyInfo( String compantTelNumber);
    public ResponseDto<GetCompanyPageResponseDto> getCompanyPage(String companyTelNumber);

}
