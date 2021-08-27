package com.venchi.dark.common;

/**
 * @author liwc@tongtech.com
 * @date 2021/08/27
 */
public enum ResultEnum {
    SUCCESS(ResultCode.SUCCESS,"请求成功"),
    FAILURE(ResultCode.FAILURE,"请求失败"),
    ERROR(ResultCode.ERROR,"服务端内部异常");

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
