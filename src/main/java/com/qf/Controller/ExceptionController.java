package com.qf.Controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HP        PC on 2019/11/27.
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public String excepiton(){
        return "noroot";
    }
}
