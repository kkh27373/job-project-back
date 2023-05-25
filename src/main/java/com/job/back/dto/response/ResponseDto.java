package com.job.back.dto.response;

import com.job.back.common.constant.ResponseMessage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "Response Format")
@Data
@AllArgsConstructor(staticName = "set")
@NoArgsConstructor
public class ResponseDto<D> {

    @ApiModelProperty(value = "작업 결과 상태", example = "true", required = true)
    private boolean result;
    @ApiModelProperty(value = "작업결과 메세지", example = ResponseMessage.SUCCESS, required = true)
    private String message;
    @ApiModelProperty(value = "작업 결과 데이터", required = true)
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
