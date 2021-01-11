package com.altimetrik.spring.boot.workshop.exception;

import com.altimetrik.spring.boot.workshop.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class WorkshopControllerAdvice {

    @ExceptionHandler(WorkshopException.class)
    public ResponseEntity<BaseResponse> handleWorkshopException(WorkshopException ex){
        log.error("Workshop Exception Thrown: {}", ex);
        BaseResponse baseResponse = new BaseResponse( String.valueOf(ex.getHttpStatus().value()), ex.getMessage());
        return new ResponseEntity(baseResponse, ex.getHttpStatus());
    }
}
