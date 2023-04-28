package com.job.back.service;

import com.job.back.dto.request.user.PatchUserComponentDto;
import com.job.back.dto.request.user.ValidateUserEmailDto;
import com.job.back.dto.request.user.ValidateUserTelNumberDto;
import com.job.back.dto.response.ResponseDto;
import com.job.back.dto.response.user.GetUserResponseDto;
import com.job.back.dto.response.user.PatchUserComponentResponseDto;
import com.job.back.dto.response.user.ValidateEmailResponseDto;
import com.job.back.dto.response.user.ValidateTelNumberResponseDto;

public interface UserService {
    public ResponseDto<PatchUserComponentResponseDto> patchUserSelectComponent(String userEmail, PatchUserComponentDto dto );
    public ResponseDto<GetUserResponseDto> getUser(String userEmail);
    public ResponseDto<ValidateEmailResponseDto> validateEmail(ValidateUserEmailDto dto);
    public ResponseDto<ValidateTelNumberResponseDto> validateTelNumber(ValidateUserTelNumberDto dto);
}
