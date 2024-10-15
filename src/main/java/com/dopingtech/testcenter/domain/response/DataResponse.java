package com.dopingtech.testcenter.domain.response;

public class DataResponse<T> extends Response{

    private final T data;

    public DataResponse(boolean success, T data) {
        super(success);
        this.data = data;
    }

    public DataResponse(boolean success, String message, T data) {
        super(success, message);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
