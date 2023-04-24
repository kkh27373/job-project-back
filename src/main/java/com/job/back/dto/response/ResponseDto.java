<<<<<<< HEAD:src/main/java/com/job/back/dto/response/ResponseDto.java
package com.job.back.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "set")
@NoArgsConstructor
public class ResponseDto<D> {

    private boolean result;

    private String message;

    private D data;

    public static <D> ResponseDto<D> setSucess(String message,D data) {
        // ^  @AllArgsConstructor(staticName = "set") 이거를 불러오는 거 set으로 
        return ResponseDto.set(true, message, data);
    }

    public static <D> ResponseDto setFailed(String message){
        // ^ 실패 이므로 Data에는 null 값 
        return ResponseDto.set(false, message, null);
    }
=======
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

>>>>>>> a6b9c81390ec544bab5fffc18ff293102fa290c4:src/main/java/com/job/back/dto/responser/ResponseDto.java
    
}
