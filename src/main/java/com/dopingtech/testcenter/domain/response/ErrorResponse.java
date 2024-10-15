package com.dopingtech.testcenter.domain.response;

public class ErrorResponse extends Response{

    public ErrorResponse() {
        super(false);
    }

    public ErrorResponse(String message) {
        super(false, message);
    }
}
