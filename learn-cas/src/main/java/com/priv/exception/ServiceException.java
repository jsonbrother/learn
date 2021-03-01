package com.priv.exception;

import com.priv.enums.ResponseEnum;

/**
 * @author Json
 * @date 2021/3/1 21:34
 */
public class ServiceException extends RuntimeException {

    private ResponseEnum responseEnum;

    ServiceException(ResponseEnum responseEnum) {
        super("异常状态码为：" + responseEnum.status() + "；具体异常信息为：" + responseEnum.msg());
        this.responseEnum = responseEnum;
    }

    public ResponseEnum getResponseEnum() {
        return responseEnum;
    }

    public void setResponseEnum(ResponseEnum responseEnum) {
        this.responseEnum = responseEnum;
    }
}
