package com.melita.interceptor;


import com.melita.exception.OrderException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;

@Component
public class AutheticationInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(AutheticationInterceptor.class);

    public AutheticationInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String xAuth = request.getHeader("x-auth");
        String path = request.getRequestURI();


        if (StringUtils.isAllEmpty(xAuth)) {
            log.error("Autentication error x-auth empty");
            ErrorType errorType = getError("empty");
            throw new OrderException(7, "KO", errorType, null, null);
        }

        String authToken = Base64.getEncoder().encodeToString((path).getBytes());

        if (!xAuth.equalsIgnoreCase(authToken)) {
            ErrorType errorType = getError("token");
            throw new OrderException(7, "KO", errorType, null, null);
        }

        return true;
    }

    private ErrorType getError(String reason) {

        final String ACCESS_DENIED = "ACCESS DENIED";

        ErrorType error= new ErrorType();
        switch (reason) {
            case "token":
                error.setErrorCode("403");
                error.setErrorDescription(ACCESS_DENIED + " - ERROR TOKEN");
                break;
            case "empty":
                error.setErrorCode("403");
                error.setErrorDescription(ACCESS_DENIED + " - TOKEN AND SOURCE MUST NOT BE NULL");
                break;
            default:
                break;
        }
        return error;

    }

}
