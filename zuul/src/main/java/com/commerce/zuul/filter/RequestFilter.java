package com.commerce.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LogFilter extends ZuulFilter {

	private static final Logger LOG = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public boolean shouldFilter() {

		return true;
	}

	@Override
	public Object run() throws ZuulException {

		final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

		LogFilter.LOG.info("**** Requête interceptée ! L'URL est : {}", request.getRequestURL());

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
