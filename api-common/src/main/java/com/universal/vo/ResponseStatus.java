package com.universal.vo;

/**
 * @author YIJIUE
 */
public enum ResponseStatus {
    SUCCESS(0, "执行成功"),
    ERRCODE(1, "执行失败");

    private int code;
    private String msg;

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
