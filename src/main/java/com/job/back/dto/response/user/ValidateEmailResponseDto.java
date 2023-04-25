package com.job.back.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateEmailResponseDto {
    // userEmail 중복 확인하는 메서드
    private boolean result;

}
