/**
 * 
 */
package com.ibermatica.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ibermatica.rest.webservices.restfulwebservices.user.UserNotFoundException;

/**
 * The customized response entity exception handler.
 *
 * @author pvraul1
 * @since 1.8
 * @version 15 ene. 2020 11:48:54
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(false))
                .build();
        
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
