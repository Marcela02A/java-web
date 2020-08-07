package com.cars.controller.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class ResponseWrapper extends HttpServletResponseWrapper {

	private final HttpServletRequest request;

	public ResponseWrapper(HttpServletResponse response, HttpServletRequest _request) {
		super(response);
		request = _request;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		setContentType(this.request.getHeader("Content-Type"));
		return super.getWriter();
	}
	
	
}
