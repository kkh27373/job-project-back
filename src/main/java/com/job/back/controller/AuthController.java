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
    
    private final String USER_SIGN_UP = "/signup/user";
    private final String USER_LOG_IN = "/login/user";
    private final String COMPANY_SIGN_UP = "/signup/company";
    private final String COMPANY_LOG_IN = "/login/company";

    @PostMapping(USER_SIGN_UP)
    public ResponseDto<UserSignUpResonseDto> userSignUp(@Valid @RequestBody UserSignUpDto requestBody){
        ResponseDto<UserSignUpResonseDto> response = authService.userSignUp(requestBody);
        return response;
    }

    @PostMapping(COMPANY_SIGN_UP)
    public ResponseDto<CompanySignUpResponseDto> companySignUp(@Valid @RequestBody CompanySignUpDto requestBody){
        System.out.println("API companySignUp Request body :" + requestBody.toString());
        ResponseDto<CompanySignUpResponseDto> response = authService.companySignUp(requestBody);
        return response;
    }

    @PostMapping(USER_LOG_IN)
    public ResponseDto<UserSignInResponseDto> userSignIn(@Valid @RequestBody UserSignInDto requestBody){
        ResponseDto<UserSignInResponseDto> response = authService.userSignIn(requestBody);
        return response;
    }

    @PostMapping(COMPANY_LOG_IN)
    public ResponseDto<CompanySignInResponseDto> companySignIn(@Valid @RequestBody CompanySignInDto requestBody){
        ResponseDto<CompanySignInResponseDto> response = authService.companySignIn(requestBody);
        return response;
    }


}
