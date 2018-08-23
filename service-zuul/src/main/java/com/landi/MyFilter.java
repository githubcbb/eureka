package com.landi;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cbb on 2018/7/19.
 */
@Component
public class MyFilter extends ZuulFilter{

/*  filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
    pre：路由之前
    routing：路由之时
    post： 路由之后
    error：发送错误调用*/
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {//过滤的顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {//这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
        return true;
    }

    @Override
    public Object run() throws ZuulException {//过滤器的具体逻辑。可用很复杂，包括查sql去判断该请求到底有没有权限访问。
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getMethod()+"---"+request.getRequestURL());
//        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            System.out.println("token is empty");
//            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        System.out.println("ok");
//        log.info("ok");
        return null;
    }
}
