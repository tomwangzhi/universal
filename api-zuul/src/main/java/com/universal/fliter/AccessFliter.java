package com.universal.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.http.HttpServletRequest;


/**
 * @author YIJIUE
 */
@Component
public class AccessFliter extends ZuulFilter {

    /**
     *  过滤器的类型：
     *  pre：可以在请求被路由之前调用。
       routing：在路由请求时候被调用。
       post：在routing和error过滤器之后被调用。
       error：处理请求时发生错误时被调用。
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }


    /**
     * 自己自定义过滤执行的顺序，比如又自定义一个过滤器AccessFliterOther,设置成-9，那么这个会在前面执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 过滤器执行的业务逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        requestContext.setResponseBody("{\"code\":403,\"msg\":\"Forbidden\"}");
        requestContext.setSendZuulResponse(false);

        return null;
    }

    /**
     * 过滤器执行的条件，在哪种情况下被执行
     * 这里表示路径中含有user/access的路径会被执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        return PatternMatchUtils.simpleMatch("*user/access*", request.getRequestURI());
    }

    
}

