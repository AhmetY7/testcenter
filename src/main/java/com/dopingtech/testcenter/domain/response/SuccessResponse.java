package com.dopingtech.testcenter.domain.response;

public class SuccessResponse extends Response{

    public SuccessResponse() {
        super(true);
    }

    public SuccessResponse(String message) {
        super(true, message);
    }
}
