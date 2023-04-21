package com.job.back.dto.responser.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateTelNumberResponseDto {
    //userTelNumber 중복 확인 하는 메서드
    private boolean result;
    
}
