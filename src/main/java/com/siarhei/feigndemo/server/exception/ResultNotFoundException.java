package com.siarhei.feigndemo.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResultNotFoundException extends RuntimeException {

    public ResultNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
