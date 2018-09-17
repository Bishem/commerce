package com.mycommerce.zuul.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

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

		ResponseFilter.LOG.info("**** CODE HTTP {}", response.getStatus());

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
