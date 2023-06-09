package com.job.back.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.back.common.constant.ApiPattern;
import com.job.back.dto.Add_User_Wish_List_Dto;
import com.job.back.dto.User_Select_Component_Dto;
import com.job.back.dto.request.user.PatchUserProfilDto;
import com.job.back.dto.request.user.ValidateUserEmailDto;
import com.job.back.dto.request.user.ValidateUserTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.user.AddUserWishListResponseDto;
import com.job.back.dto.response.user.GetUserResponseDto;
import com.job.back.dto.response.user.PatchUserComponentResponseDto;
import com.job.back.dto.response.user.PatchUserProfileResponseDto;
import com.job.back.dto.response.user.ValidateEmailResponseDto;
import com.job.back.dto.response.user.ValidateTelNumberResponseDto;
import com.job.back.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(description = "유저 모듈")
@RestController
@RequestMapping(ApiPattern.USER)
public class UserController {
    
     @Autowired private UserService userService;

     private final String GET_USER = "/";
     private final String VALIDATE_USER_EMAIL = "/validate/userEmail";
     private final String VALIDATE_USER_TEL_NUMBER = "/validate/userTelNumber";
     private final String USER_SELECT_COMPONENT = "/select-component";
     private final String ADD_USER_WISH_LIST = "/user-wish-list";
     private final String PATH_PROFILE = "/profile";

    

     @ApiOperation(value = "유저 정보 불러오기", notes = "Request Header Authorization에 Bearer Token을 포함하여 요청을 하면, 성공시 유저 정보를 반환하고 실패시 실패 메세지를 반환")
     @GetMapping(GET_USER)
     public ResponseDto<GetUserResponseDto> getUser
     (@AuthenticationPrincipal String userEmail) {
        ResponseDto<GetUserResponseDto> response = userService.getUser(userEmail);
        return response;
     }

     @ApiOperation(value = "유저 이메일 중복 체크", notes = "Request Body에 email을 포함하여 요청하면, 중복 결과를 반환, 실패시 실패 메세지를 반환")
     @PostMapping(VALIDATE_USER_EMAIL)
     public ResponseDto<ValidateEmailResponseDto> validateEmail
     (@Valid @RequestBody ValidateUserEmailDto requsetBody
     ) {
        ResponseDto<ValidateEmailResponseDto> response = userService.validateEmail(requsetBody);
        return response;
     };

     @ApiOperation(value = "유저 전화번호 중복 체크", notes="Request Body에 telNumber를 포함하여 요청하면, 중복 결과를 반환, 실패시 실패 메세지를 반환")
     @PostMapping(VALIDATE_USER_TEL_NUMBER)
     public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber
     (@Valid @RequestBody ValidateUserTelNumberDto requsetBody
     ) {
        ResponseDto<ValidateTelNumberResponseDto> response = userService.validateTelNumber(requsetBody);
        return response;
     };

     @ApiOperation(value = "유저 정보 추가 ", notes="유저 최종학력,유저 경력,유저자격증을 유저 이메일이랑 같이 보내면 유저 정보에 추가를 하고 실패시 실패 메세지를 반환. ")
     @PostMapping(USER_SELECT_COMPONENT)
     public ResponseDto<PatchUserComponentResponseDto> patchUserSelectComponent
     (@AuthenticationPrincipal String email, 
      @Valid @RequestBody User_Select_Component_Dto user_Select_Component_Dto){

      ResponseDto<PatchUserComponentResponseDto> response = userService.patchUserSelectComponent(email,user_Select_Component_Dto );

      return response;
      
      }

      @ApiOperation(value = "유저 점수 및 퍼센트",notes = " ")
      @PostMapping(ADD_USER_WISH_LIST)
      public ResponseDto<AddUserWishListResponseDto> addUserWishList(
         @AuthenticationPrincipal String email,
         @Valid @RequestBody Add_User_Wish_List_Dto dto
      ){

         ResponseDto<AddUserWishListResponseDto> response  = userService.addUserWishList(email,dto.getCompany_Tel_Number());

         return response;

      }

      @ApiOperation(value = "유저 프로필 URL 수정", notes = "Request Header Authorization에 Bearer JWT를 포함하여 Request Bpdy에 profile을 포함하여 요청을 하면, 성공시 유저 정보를 반환, 실패시 실패 메세지를 반환")
      @PatchMapping(PATH_PROFILE)
      public ResponseDto<PatchUserProfileResponseDto> patchUserProfile(
         @ApiParam(hidden = true)
         @AuthenticationPrincipal String userEmail,
         @Valid @RequestBody PatchUserProfilDto requestBody
      ) {
         ResponseDto<PatchUserProfileResponseDto> response = userService.patchUserProfile(userEmail,requestBody);
         return response;
      }



   }
