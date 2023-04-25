package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.dto.request.auth.UserSignInDto;
import com.job.back.dto.request.auth.UserSignUpDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.auth.UserSignInResponseDto;
import com.job.back.dto.response.auth.UserSignUpResonseDto;
import com.job.back.service.AuthService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class AuthController {

    @Autowired private AuthService authService;

    private final String SIGN_UP = "/sign-up";
    private final String SIGN_IN = "sign-in";
   
    @ApiOperation(value = "회원가입")
    @PostMapping(SIGN_UP)
    public ResponseDto<UserSignUpResonseDto> userSignUp(@Valid @RequestBody UserSignUpDto requestBody) {
        ResponseDto<UserSignUpResonseDto> response = authService.userSignUp(requestBody);
        return response;
    }

    @ApiOperation(value = "로그인")
    @PostMapping(SIGN_IN)
    public ResponseDto<UserSignInResponseDto> userSignIn(@Valid @RequestBody UserSignInDto requestBody) {
        ResponseDto<UserSignInResponseDto> response = authService.userSignIn(requestBody);
        return response;
    }
    
}
