package com.priv.enums;

/**
 * @author Json
 * @date 2021/3/1 21:23
 */
public enum ResponseEnum {

    SUCCESS(200, true, "成功"),

    FAILED(500, false, "失败"),

    ILLEGAL_ARGUMENT(501, false, "参数不合法"),

    REPETITIVE_OPERATION(502, false, "请勿重复操作");

    /**
     * 响应业务状态
     */
    private Integer status;
    /**
     * 调用是否成功
     */
    private Boolean success;
    /**
     * 响应消息 可以为成功或者失败的消息
     */
    private String msg;

    ResponseEnum(Integer status, Boolean success, String msg) {
        this.status = status;
        this.success = success;
        this.msg = msg;
    }

    public Integer status() {
        return status;
    }

    public Boolean success() {
        return success;
    }

    public String msg() {
        return msg;
    }
}
