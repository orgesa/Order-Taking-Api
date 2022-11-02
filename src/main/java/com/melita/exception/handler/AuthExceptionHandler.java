package com.melita.exception.handler;


import com.melita.exception.OrderException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.melita.interceptor.ErrorType;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class AuthExceptionHandler {


    @ExceptionHandler(OrderException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleConstraintViolation(OrderException ex, HttpServletRequest request) {


        ErrorType errorType = ex.getErrorType();

        if(StringUtils.isNumeric(errorType.getErrorCode())){
            return new ResponseEntity<>(ex, HttpStatus.resolve(Integer.parseInt(errorType.getErrorCode())));
        }else {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}