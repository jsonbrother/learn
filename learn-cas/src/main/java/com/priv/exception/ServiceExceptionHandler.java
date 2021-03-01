package com.priv.exception;

import com.priv.model.result.GraceJsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Json
 * @date 2021/3/1 21:36
 */
@ControllerAdvice
public class ServiceExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public GraceJsonResult serviceExceptionHandler(ServiceException e) {
        e.printStackTrace();
        return GraceJsonResult.exception(e.getResponseEnum());
    }

}
