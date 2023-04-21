package com.job.back.dto.responser.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateEmailResponseDto {
    // userEmail이 중복이 확인하는 메서드
    private boolean result;

}
