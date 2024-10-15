package com.dopingtech.testcenter.domain.exception;

import com.dopingtech.testcenter.domain.response.ErrorDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<ErrorDataResponse<ApiException>> handleApiRequestException(ApiRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(new ErrorDataResponse<>(new ApiException(e.getMessage(), badRequest)), badRequest);
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<ErrorDataResponse<ApiException>> handleNoSuchElementException(NoSuchElementException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(new ErrorDataResponse<>(new ApiException(e.getMessage(), notFound)), notFound);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDataResponse<ApiException>> handleGeneralExceptions(Exception e) {
        HttpStatus notFound = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(new ErrorDataResponse<>(new ApiException(e.getMessage(), notFound)), notFound);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDataResponse<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResponse<>("Validation Errors!", validationErrors);
    }

}
