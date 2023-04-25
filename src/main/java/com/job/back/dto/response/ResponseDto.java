package com.job.back.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "set")
@NoArgsConstructor
public class ResponseDto<D> {

    private boolean result;

    private String message;

    private D data;

    public static <D> ResponseDto<D> setSuccess(String message,D data) {
        // ^  @AllArgsConstructor(staticName = "set") 이거를 불러오는 거 set으로 
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto setFailed(String message){
        // ^ 실패 이므로 Data에는 null 값 
        return ResponseDto.set(false, message, null);
    }
    
}
