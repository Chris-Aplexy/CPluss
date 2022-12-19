package com.company.cpluss.Configurations.ExceptionHandling;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLInvalidAuthorizationSpecException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthenticationException.class)
    public ResponseEntity InvalidAuthenticationExceptionHandler(HttpServletRequest httpServletRequest, AuthenticationException authenticationException){
        String errorMessage = authenticationException.getMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity SQLIntegrityConstraintViolationExceptionHandler(HttpServletRequest httpServletRequest, SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException){
        String error = sqlIntegrityConstraintViolationException.getMessage();
        return ResponseEntity.badRequest().body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SQLException.class)
    public ResponseEntity SQLExceptionHandler(HttpServletRequest httpServletRequest,
                                              SQLException sqlException){
        String errormsg = sqlException.getMessage();
        return ResponseEntity.badRequest().body(errormsg);
    }
}
