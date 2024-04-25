package com.zhimaxu.common.core.domain;/*
 * @author xxc
 * @date 2024/4/25 下午3:25
 */

import com.zhimaxu.common.core.constant.Constants;

import java.io.Serial;
import java.io.Serializable;

public class Response<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = Constants.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constants.FAIL;

    private int code;

    private String msg;

    private T data;

    public static <T> Response<T> ok() {
        return restResult(null, SUCCESS, null);
    }

    public static <T> Response<T> ok(T data) {
        return restResult(data, SUCCESS, null);
    }

    public static <T> Response<T> ok(T data, String msg) {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> Response<T> fail() {
        return restResult(null, FAIL, null);
    }

    public static <T> Response<T> fail(String msg) {
        return restResult(null, FAIL, msg);
    }

    public static <T> Response<T> fail(T data) {
        return restResult(data, FAIL, null);
    }

    public static <T> Response<T> fail(T data, String msg) {
        return restResult(data, FAIL, msg);
    }

    public static <T> Response<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> Response<T> restResult(T data, int code, String msg) {
        Response<T> res = new Response<>();
        res.setCode(code);
        res.setData(data);
        res.setMsg(msg);
        return res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Boolean isError(Response<T> res) {
        return !isSuccess(res);
    }

    public static <T> Boolean isSuccess(Response<T> res) {
        return Response.SUCCESS == res.getCode();
    }
}
