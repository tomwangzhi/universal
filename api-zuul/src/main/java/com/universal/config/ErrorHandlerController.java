package com.universal.config;

import com.universal.vo.ResponseApi;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义 zuul 路由异常
 * @author YIJIUE
 */
@RestController
public class ErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Object error(){
        /*RequestContext ctx = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException)ctx.getThrowable();*/
        return ResponseApi.fail("sorry, server access be more, please try again later");
    }

}
