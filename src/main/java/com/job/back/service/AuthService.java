package com.job.back.service;

import com.job.back.dto.request.auth.CompanySignInDto;
import com.job.back.dto.request.auth.CompanySignUpDto;
import com.job.back.dto.request.auth.UserSignInDto;
import com.job.back.dto.request.auth.UserSignUpDto;
import com.job.back.dto.responser.ResponseDto;

public interface AuthService {
    public ResponseDto<UserSignUpDto> userSignUp(UserSignUpDto dto);
    public ResponseDto<UserSignInDto> userSignIn(UserSignInDto dto);
    public ResponseDto<CompanySignUpDto> companySignUp(CompanySignUpDto dto);
    public ResponseDto<CompanySignInDto> companySignIn(CompanySignInDto dto);
}
