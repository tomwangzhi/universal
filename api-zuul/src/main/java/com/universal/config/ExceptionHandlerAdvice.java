package com.universal.config;

import com.netflix.client.ClientException;
import com.netflix.zuul.exception.ZuulException;
import com.universal.vo.ResponseApi;
import com.universal.vo.ResponseVo;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常切面拦截
 * @author YIJIUE
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ZuulException.class)
    @ResponseBody
    public ResponseVo serverException(ZuulException e) {
        //log.error("服务端异常", throwable);
        return ResponseApi.fail(e.toString());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> servException(Throwable e) {
        Map<String, Object> data = new HashMap<>();
        data.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        data.put("message", "server access be more, please try again later!");

        return data;
    }
}
