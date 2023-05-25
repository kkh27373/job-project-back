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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;

@RestController
@RequestMapping(ApiPattern.AUTH)
@Api(description = "인증모듈")
public class AuthController {
    @Autowired private AuthService authService;
    
    private final String USER_SIGN_UP = "/signup/user";
    private final String USER_LOG_IN = "/login/user";
    private final String COMPANY_SIGN_UP = "/signup/company";
    private final String COMPANY_LOG_IN = "/login/company";

    @ApiOperation(value = "유저 회원가입",notes = "유저이메일,유저패스워드,유저전화번호,유저이름,유저주소,유저나이,유저성별을 기입해서 회원을 등록하고, 성공 시에는 회원가입 성공 여부에 true가 반환된다.")
    @PostMapping(USER_SIGN_UP)
    public ResponseDto<UserSignUpResonseDto> userSignUp(@Valid @RequestBody UserSignUpDto requestBody){
        ResponseDto<UserSignUpResonseDto> response = authService.userSignUp(requestBody);
        return response;
    }
    @ApiOperation(value = "회사 회원가입", notes = "회사 전화번호,회사 이름, 회사 주소, 회사 패스워드,회사 이메일을 입력하여 회사 회원을 등록하고, 성공 시에는 회원가입 성공 여부에 true가 반환된다.")
    @PostMapping(COMPANY_SIGN_UP)
    public ResponseDto<CompanySignUpResponseDto> companySignUp(@Valid @RequestBody CompanySignUpDto requestBody){
        System.out.println("API companySignUp Request body :" + requestBody.toString());
        ResponseDto<CompanySignUpResponseDto> response = authService.companySignUp(requestBody);
        return response;
    }

    @ApiOperation(value = "유저 로그인", notes = "아이디와 비밀번호를 입력할시 일치할 경우, 회원 정보와 토큰 만료기간을 반환하고, 실패한다면 해당 메세지를 반환")
    @PostMapping(USER_LOG_IN)
    public ResponseDto<UserSignInResponseDto> userSignIn(@Valid @RequestBody UserSignInDto requestBody){
        ResponseDto<UserSignInResponseDto> response = authService.userSignIn(requestBody);
        return response;
    }

    @ApiOperation(value = "회사 로그인",notes = "아이디와 비밀번호를 입력할시 일치할 경우, 회원 장보와 토큰 만료기간을 반환하고, 실패한다면 해당 메세지를 반환")
    @PostMapping(COMPANY_LOG_IN)
    public ResponseDto<CompanySignInResponseDto> companySignIn(@Valid @RequestBody CompanySignInDto requestBody){
        ResponseDto<CompanySignInResponseDto> response = authService.companySignIn(requestBody);
        return response;
    }


}
