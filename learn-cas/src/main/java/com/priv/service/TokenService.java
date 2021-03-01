package com.priv.service;

import com.priv.model.result.GraceJsonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Json
 * @date 2021/3/1 21:41
 */
public interface TokenService {

    /**
     * 创建token
     *
     * @return 返回token
     */
    GraceJsonResult createToken();

    /**
     * 检查token
     *
     * @param request 请求对象
     * @return 返回token
     */
    GraceJsonResult checkToken(HttpServletRequest request);
}
