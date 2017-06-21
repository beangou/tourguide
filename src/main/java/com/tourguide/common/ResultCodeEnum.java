package com.tourguide.common;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by liutongbin on 2017/4/5.
 */
public enum ResultCodeEnum {

    SUCCESS(0, "成功"),
    EXCEPTION(-1, "未知异常"),
    PARAM_ERROR(400, "参数错误"),
    ;

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    ResultCodeEnum (int code, String message) {
        this.code = code;
        this.message = message;
    }

}
