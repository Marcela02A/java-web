package com.cars.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter(urlPatterns = "*.do")
public class CompressionFilter implements Filter {

	static Logger logger = LogManager.getLogger(LogginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest _request = (HttpServletRequest) request;
			HttpServletResponse _response = (HttpServletResponse) response;
			String ae = _request.getHeader("Accept-Encoding");
			if (ae != null && ae.indexOf("gzip") != -1) {
				logger.info("[Compression Filter]called");
				GZIPResponseWraper wrapperResponse = new GZIPResponseWraper(_response);
				chain.doFilter(request, wrapperResponse);
			} else {
				chain.doFilter(_request, response);
			}
		}
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
