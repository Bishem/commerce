package com.commerce.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ResponseFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseFilter.class);

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {

        final HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        ResponseFilter.LOG.info("**** Reponse interceptée ! Le Status est : {}", response.getStatus());

        return null;
    }

    @Override
    public String filterType() {

        return "pre";
    }

    @Override
    public int filterOrder() {

        return 1;
    }

}
