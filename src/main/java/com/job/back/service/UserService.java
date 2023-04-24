package com.job.back.service;

import com.job.back.dto.request.user.PatchUserComponentDto;
import com.job.back.dto.responser.ResponseDto;
import com.job.back.dto.responser.user.GetUserResponseDto;
import com.job.back.dto.responser.user.PatchUserComponentResponseDto;

public class UserService {
    public ResponseDto<PatchUserComponentResponseDto> patchProfile(String userFinalEducation, PatchUserComponentDto dto );
    public ResponseDto<GetUserResponseDto> getUser(String userEmail);
}
