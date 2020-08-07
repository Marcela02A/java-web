package com.cars.controller.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.logging.log4j.Logger;

public class LogRequestWrapper extends HttpServletRequestWrapper {
	Logger logger;

	public LogRequestWrapper(HttpServletRequest request, Logger logger) {
		super(request);
		this.logger = logger;
	}

	@Override
	public String getHeader(String name) {
		String header = super.getHeader(name);
		logger.info("[getHeader] Asked for: " + name + ";got: " + header);
		return header;
	}

}
