package com.priv.model.result;

import com.priv.enums.ResponseEnum;

import java.util.Map;

/**
 * @author Json
 * @date 2021/3/1 21:31
 */
public class GraceJsonResult {

    // 响应业务状态码
    private Integer status;

    // 响应消息
    private String msg;

    // 是否成功
    private Boolean success;

    // 响应数据（可以是Object,也可以是List或Map等）
    private Object data;

    /**
     * 成功返回
     * 不带有数据的 直接调用success方法,data无须传入（其实就是null）
     */
    public static GraceJsonResult success() {
        return new GraceJsonResult(ResponseEnum.SUCCESS);
    }

    /**
     * 成功返回
     * 带有数据的 直接往success方法丢data数据即可
     */
    public static GraceJsonResult success(Object data) {
        return new GraceJsonResult(data);
    }

    /**
     * 错误返回
     * 直接调用error方法即可 当然也可以在ResponseStatusEnum中自定义错误后再返回也都可以
     */
    public static GraceJsonResult error() {
        return new GraceJsonResult(ResponseEnum.FAILED);
    }

    /**
     * 错误返回
     * 直接返回错误的消息
     */
    public static GraceJsonResult errorMsg(String msg) {
        return new GraceJsonResult(ResponseEnum.FAILED, msg);
    }

    /**
     * 错误返回
     * map中包含了多条错误信息 可以用于表单验证 把错误统一的全部返回出去
     */
    public static GraceJsonResult errorMap(Map map) {
        return new GraceJsonResult(ResponseEnum.FAILED, map);
    }

    /**
     * 自定义错误范围
     * 需要传入一个自定义的枚举 可以到[ResponseStatusEnum.java]中自定义后再传入
     */
    public static GraceJsonResult errorCustom(ResponseEnum responseStatus) {
        return new GraceJsonResult(responseStatus);
    }

    public static GraceJsonResult exception(ResponseEnum responseStatus) {
        return new GraceJsonResult(responseStatus);
    }

    public GraceJsonResult() {

    }

    private GraceJsonResult(Object data) {
        this.status = ResponseEnum.SUCCESS.status();
        this.msg = ResponseEnum.SUCCESS.msg();
        this.success = ResponseEnum.SUCCESS.success();
        this.data = data;
    }

    private GraceJsonResult(ResponseEnum responseStatus) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
    }

    private GraceJsonResult(ResponseEnum responseStatus, Object data) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
        this.data = data;
    }

    private GraceJsonResult(ResponseEnum responseStatus, String msg) {
        this.status = responseStatus.status();
        this.msg = msg;
        this.success = responseStatus.success();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
