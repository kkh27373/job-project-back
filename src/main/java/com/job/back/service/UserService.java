package com.job.back.service;

import com.job.back.dto.User_Select_Component_Dto;
import com.job.back.dto.request.company.PatchCompanyProfileDto;
import com.job.back.dto.request.user.PatchUserProfilDto;
import com.job.back.dto.request.user.ValidateUserEmailDto;
import com.job.back.dto.request.user.ValidateUserTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.applicant.GetApplicantDataResponseDto;
import com.job.back.dto.response.user.AddUserWishListResponseDto;
import com.job.back.dto.response.user.GetUserResponseDto;
import com.job.back.dto.response.user.PatchUserComponentResponseDto;
import com.job.back.dto.response.user.PatchUserProfileResponseDto;
import com.job.back.dto.response.user.ValidateEmailResponseDto;
import com.job.back.dto.response.user.ValidateTelNumberResponseDto;

public interface UserService {
    public ResponseDto<PatchUserProfileResponseDto> patchUserProfile(String userEmail, PatchUserProfilDto dto);
    public ResponseDto<PatchUserComponentResponseDto> patchUserSelectComponent(String userEmail, User_Select_Component_Dto dto );
    public ResponseDto<GetUserResponseDto> getUser(String userEmail);
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateUserEmailDto dto);
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateUserTelNumberDto dto);
    public ResponseDto<AddUserWishListResponseDto> addUserWishList(String userEmail,String company_tel_number);
    public ResponseDto<GetApplicantDataResponseDto> getApplicantData(String userEmail);
}
