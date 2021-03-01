package com.priv.aspect;

import com.priv.enums.ResponseEnum;
import com.priv.exception.GraceException;
import com.priv.exception.ServiceException;
import com.priv.model.result.GraceJsonResult;
import com.priv.service.TokenService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Json
 * @date 2021/3/1 22:54
 */
@Aspect
@Configuration
public class TokenAspect {

    @Autowired
    private TokenService tokenService;

    @Around(value = "@annotation(com.priv.ants.CheckToken2)")
    public Object checkTokenAspect(ProceedingJoinPoint joinPoint) {
        //  获取request中token
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        tokenService.checkToken(request);

        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            GraceException.display(ResponseEnum.FAILED);
        }

        return proceed;
    }

}
