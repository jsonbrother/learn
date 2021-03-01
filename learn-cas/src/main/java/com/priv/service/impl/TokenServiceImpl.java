package com.priv.service.impl;

import com.priv.enums.ResponseEnum;
import com.priv.exception.GraceException;
import com.priv.model.result.GraceJsonResult;
import com.priv.service.TokenService;
import com.priv.utils.RedisOperator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author Json
 * @date 2021/3/1 21:42
 */
@Service
public class TokenServiceImpl implements TokenService {

    private final RedisOperator redis;

    @Autowired
    public TokenServiceImpl(RedisOperator redis) {
        this.redis = redis;
    }

    @Override
    public GraceJsonResult createToken() {

        // 1.生成uuid当作token
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        // 2.将生成的token存入redis中
        redis.set(token, token);

        // 3.返回正确的结果信
        return GraceJsonResult.success(token);
    }

    @Override
    public GraceJsonResult checkToken(HttpServletRequest request) {

        // 1.从请求头中获取token
        String token = request.getHeader("token");
        if (StringUtils.isBlank(token)) {

            // 1.2.如果请求头token为空就从参数中获取
            token = request.getParameter("token");

            // 1.3.如果都为空抛出参数异常的错误
            if (StringUtils.isBlank(token)) {
                GraceException.display(ResponseEnum.ILLEGAL_ARGUMENT);
            }
        }
        // 2.如果redis中不包含该token 说明token已经被删除了 抛出请求重复异常
        if (!redis.keyIsExist(token)) {
            GraceException.display(ResponseEnum.REPETITIVE_OPERATION);
        }

        // 3.删除token
        Boolean del = redis.del(token);
        //如果删除不成功（已经被其他请求删除），抛出请求重复异常
        if (!del) {
            GraceException.display(ResponseEnum.REPETITIVE_OPERATION);
        }
        return GraceJsonResult.success();
    }
}
