package com.tourguide.common;

import com.tourguide.common.enums.ResultCodeEnum;
import com.tourguide.entity.BaseEntity;

/**
 * Created by liutongbin on 2017/4/5.
 */
public class Result<T> extends BaseEntity {

    private int code;
    private String message;
    private T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result(ResultCodeEnum.SUCCESS, null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> Result<T> exception() {
        return new Result(ResultCodeEnum.EXCEPTION, null);
    }

    public static <T> Result<T> paramError(String message) {
        return new Result(ResultCodeEnum.PARAM_ERROR.getCode(), message, null);
    }

    public static <T> Result<T> failure(String message) {
        return new Result(ResultCodeEnum.EXCEPTION, message);
    }

}
