package com.bugtacking.exceptionhandler;

import com.bugtacking.controller.ApplicationController;
import com.bugtacking.exception.ApplicationNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    private static final Logger LOGGER= LoggerFactory.getLogger(ApplicationController.class);

    @ExceptionHandler(ApplicationNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String applicationNotFoundExceptionHandler(final ApplicationNotFoundException ex,
                                                      final HttpServletRequest request){
        LOGGER.error("Exception while processing the request, url:{}", request.getRequestURI());
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse exceptionHandler(final Exception ex, final HttpServletRequest request){
        LOGGER.error("Exception while processing the request, url:{}", request.getRequestURI());

        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.callerURL(request.getRequestURI());
        return exceptionResponse;
    }
}
