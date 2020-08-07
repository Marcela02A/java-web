package com.cars.controller.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = "*")
public class LogginFilter implements Filter {

	static Logger logger = LogManager.getLogger(LogginFilter.class);
	FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		filterConfig.getServletContext().log("doFilter");
		logger.info("request made to: '" + ((HttpServletRequest) request).getRequestURI() + "'");
		LogRequestWrapper wrapper = new LogRequestWrapper((HttpServletRequest) request, logger);

		ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response,
				(HttpServletRequest) wrapper);
		
		chain.doFilter(wrapper, responseWrapper);
	}

	@Override
	public void destroy() {

		Filter.super.destroy();
	}

}
