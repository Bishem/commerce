package com.commerce.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class RequestFilter extends ZuulFilter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {

        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        RequestFilter.LOG.info("**** Requête interceptée ! L'URL est : {}", request.getRequestURL());

        return null;
    }

    @Override
    public String filterType() {

        return "pre";
    }

    @Override
    public int filterOrder() {

        return 2;
    }

}
