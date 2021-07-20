package com.project.digitallibrary.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoDataFoundException extends RuntimeException {
    public NoDataFoundException(String s) {
        super(s);
    }
}