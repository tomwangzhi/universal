package com.universal.exception;

import com.universal.vo.ResponseStatus;

/**
 * @author YIJIUE
 */
public class GlobalException extends RuntimeException {

    private int code;
    private String msg;

    public GlobalException(){
        this.msg = ResponseStatus.ERRCODE.getMsg();
        this.code = ResponseStatus.ERRCODE.getCode();
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
}
