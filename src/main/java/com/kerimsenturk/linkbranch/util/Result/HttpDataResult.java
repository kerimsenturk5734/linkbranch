package com.kerimsenturk.linkbranch.util.Result;

import org.springframework.http.HttpStatus;

public class HttpDataResult<T> extends DataResult<T>{
    private HttpStatus status;

    public HttpDataResult(T data, boolean success, String message, HttpStatus status) {
        super(data, success, message);
        this.status = status;
    }

    public HttpDataResult(T data, boolean success, HttpStatus status) {
        super(data, success);
        this.status = status;
    }
}
