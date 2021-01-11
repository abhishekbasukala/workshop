package com.altimetrik.spring.boot.workshop.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class WorkshopException extends RuntimeException{

    private HttpStatus httpStatus;

    public WorkshopException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus=httpStatus;
    }
}
