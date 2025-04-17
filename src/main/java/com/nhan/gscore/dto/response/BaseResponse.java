package com.nhan.gscore.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    private T data;
    private String message;

    public static <T> BaseResponse<T> of(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setMessage("Success");
        response.setData(data);
        return response;
    }
}
