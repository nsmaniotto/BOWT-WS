package com.nsmaniotto.bowt.ws.config;

import com.nsmaniotto.bowt.ws.dto.auth.ErrorDto;
import com.nsmaniotto.bowt.ws.exceptions.BowtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {BowtException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(BowtException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new ErrorDto(ex.getMessage()));
    }
}