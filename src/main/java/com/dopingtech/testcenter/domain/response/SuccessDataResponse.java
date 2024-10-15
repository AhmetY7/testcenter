package com.dopingtech.testcenter.domain.response;

public class SuccessDataResponse<T> extends DataResponse<T> {

    public SuccessDataResponse(T data) {
        super(true, data);
    }

    public SuccessDataResponse(String message, T data) {
        super(true, message, data);
    }
}
