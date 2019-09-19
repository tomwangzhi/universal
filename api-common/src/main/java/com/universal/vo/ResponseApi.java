package com.universal.vo;

/**
 * @author YIJIUE
 */
public class ResponseApi {

    private ResponseApi() {
    }

    public static ResponseVo success(){
        return new ResponseVo(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg());
    }

    public static ResponseVo returnData(Object data){
        return new ResponseVo(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getMsg(), data);
    }

    public static ResponseVo fail(String errMsg){
        return new ResponseVo(ResponseStatus.ERRCODE.getCode(), errMsg);
    }
}
