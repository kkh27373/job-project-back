package com.job.back.service;

import com.job.back.dto.request.auth.CompanySignInDto;
import com.job.back.dto.request.auth.CompanySignUpDto;
import com.job.back.dto.request.auth.UserSignInDto;
import com.job.back.dto.request.auth.UserSignUpDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.auth.CompanySignInResponseDto;
import com.job.back.dto.response.auth.CompanySignUpResponseDto;
import com.job.back.dto.response.auth.UserSignInResponseDto;
import com.job.back.dto.response.auth.UserSignUpResonseDto;

public interface AuthService {
    public ResponseDto<UserSignUpResonseDto> userSignUp(UserSignUpDto dto);
    public ResponseDto<UserSignInResponseDto> userSignIn(UserSignInDto dto);
    public ResponseDto<CompanySignUpResponseDto> companySignUp(CompanySignUpDto dto);
    public ResponseDto<CompanySignInResponseDto> companySignIn(CompanySignInDto dto);
}
