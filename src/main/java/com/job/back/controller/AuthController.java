package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.request.auth.CompanySignInDto;
import com.job.back.dto.request.auth.CompanySignUpDto;
import com.job.back.dto.request.auth.UserSignInDto;
import com.job.back.dto.request.auth.UserSignUpDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.auth.CompanySignInResponseDto;
import com.job.back.dto.response.auth.CompanySignUpResponseDto;
import com.job.back.dto.response.auth.UserSignInResponseDto;
import com.job.back.dto.response.auth.UserSignUpResonseDto;
import com.job.back.service.AuthService;

@RestController
@RequestMapping(ApiPattern.AUTH)
public class AuthController {
    @Autowired private AuthService authService;
    
    private final String USER_SIGN_UP = "/user-sign-up";
    private final String USER_SIGN_IN = "/user-sign-in";
    private final String COMPANY_SIGN_UP = "/company-sign-up";
    private final String COMPANY_SIGN_IN = "/company-sign-in";

    // 유저 회원가입
    @PostMapping(USER_SIGN_UP)
    public ResponseDto<UserSignUpResonseDto> userSignUp(@Valid @RequestBody UserSignUpDto requestBody){
        ResponseDto<UserSignUpResonseDto> response = authService.userSignUp(requestBody);
        return response;
    }
    //회사 회원가입
    @PostMapping(COMPANY_SIGN_UP)
    public ResponseDto<CompanySignUpResponseDto> companySignUp(@Valid @RequestBody CompanySignUpDto requestBody){
        ResponseDto<CompanySignUpResponseDto> response = authService.companySignUp(requestBody);
        return response;
    }
    //유저 로그인
    @PostMapping(USER_SIGN_IN)
    public ResponseDto<UserSignInResponseDto> userSignIn(@Valid @RequestBody UserSignInDto requestBody){
        ResponseDto<UserSignInResponseDto> response = authService.userSignIn(requestBody);
        return response;
    }
    //회사 로그인
    @PostMapping(COMPANY_SIGN_IN)
    public ResponseDto<CompanySignInResponseDto> companySignIn(@Valid @RequestBody CompanySignInDto requestBody){
        ResponseDto<CompanySignInResponseDto> response = authService.companySignIn(requestBody);
        return response;
    }


}
