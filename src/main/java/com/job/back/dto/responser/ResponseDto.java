package com.job.back.dto.responser;

import org.hibernate.mapping.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "set")
public class ResponseDto<D> {
    
    //작업 결과상태
    public boolean result;
    //작업 메세지
    public String message;
    //작업 결과 데이터
    public D data;

    public static <D> ResponseDto<D> setSuccess(String message, D data){
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto<D> setFailed(String message){
        return ResponseDto.set(false, message, null);
    }

    
}
