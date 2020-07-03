package com.wh.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangwenhao
 * @description 自定义过滤器
 * @date 2020-07-02 09:27
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 过滤器类型。
     * <p>
     * 在 zuul 中定义了四种不同生命周期的过滤器类型：
     * <p>
     * 1、pre：可以在请求被路由之前调用；
     * <p>
     * 2、route：在路由请求时候被调用；
     * <p>
     * 3、post：在route和error过滤器之后被调用；
     * <p>
     * 4、error：处理请求时发生错误时被调用；
     *
     * @return 过滤器类型字符串
     */
    @Override
    public String filterType() {
        System.err.println("=======================filterType========================");
        return "pre";
    }

    /**
     * 过滤器的优先级 数字越小 优先级越高
     *
     * @return 优先级
     */
    @Override
    public int filterOrder() {
        System.err.println("=======================filterOrder========================");
        return 0;
    }

    /**
     * 是否执行该过滤器。
     * <p>
     * true：说明需要过滤；
     * <p>
     * false：说明不要过滤；
     */
    @Override
    public boolean shouldFilter() {
        System.err.println("=======================shouldFilter========================");
        return true;
    }

    /**
     * 执行过滤时的逻辑
     *
     * @return null
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.err.println("=======================run========================");
        // 获取Request对象
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String uri = request.getRequestURI();
        System.out.println("请求的URI:" + uri);

        // 模拟认证失败拦截
        if (uri.contains("1")) {
            HttpServletResponse response = context.getResponse();
            response.setContentType("text/html;charset=UTF-8");
            context.setResponse(response);
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            context.setResponseBody("认证失败");
        }
        return null;
    }
}
