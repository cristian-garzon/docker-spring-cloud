package com.springdocker.app.zuul.filters;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.Format;

@Component
public class postTimeFilter extends ZuulFilter {


    private static Logger log = LoggerFactory.getLogger(preTimeFilter.class);

    @Override
    public String filterType() {
        return "post";
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
        log.info("entering to post filter");
        Long starTime = (Long) servlet.getAttribute("starTime");
        Long endTime = System.currentTimeMillis();
        Long totalTime = endTime - starTime;
        log.info(String.format("time in second: %s", totalTime/1000));
        log.info(String.format("time in milliseconds: %s", totalTime));
        return null;
    }
}
