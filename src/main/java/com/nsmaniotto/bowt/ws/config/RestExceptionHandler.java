package com.nsmaniotto.bowt.ws.config;

import com.nsmaniotto.bowt.ws.dto.auth.ErrorDto;
import com.nsmaniotto.bowt.ws.exceptions.BowtException;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {BowtException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(BowtException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new ErrorDto(ex.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException e, WebRequest request) {
        String errorMessage = "Encountered " + NoSuchElementException.class.getSimpleName() + " on " + e.getMessage();
        log.error(errorMessage, e);
        return handleExceptionInternal(e, errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
        String errorMessage = "Encountered " + ConstraintViolationException.class.getSimpleName()
                + " with constraints: " + e.getConstraintViolations().toString();
        log.error(errorMessage, e);
        return handleExceptionInternal(e, errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}