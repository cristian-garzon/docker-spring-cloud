package com.springdocker.app.zuul.filters;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class preTimeFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(preTimeFilter.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext request = RequestContext.getCurrentContext();
        HttpServletRequest servlet = request.getRequest();
        log.info(String.format("%s request routed to %s",servlet.getMethod(), servlet.getRequestURL().toString()));
        Long starTime = System.currentTimeMillis();
        servlet.setAttribute("starTime",starTime);
        return null;
    }
}
