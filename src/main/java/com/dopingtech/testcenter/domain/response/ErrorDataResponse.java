package com.dopingtech.testcenter.domain.response;

public class ErrorDataResponse<T> extends DataResponse<T>{

    public ErrorDataResponse(T data) {
        super(false, data);
    }

    public ErrorDataResponse(String message, T data) {
        super(false, message, data);
    }
}
