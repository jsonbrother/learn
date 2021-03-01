package com.priv.exception;


import com.priv.enums.ResponseEnum;

/**
 * @author Json
 * @date 2021/3/1 21:42
 */
public class GraceException {

    public static void display(ResponseEnum responseEnum) {
        throw new ServiceException(responseEnum);
    }

}
