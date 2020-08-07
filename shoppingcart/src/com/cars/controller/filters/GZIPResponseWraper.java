package com.cars.controller.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZIPResponseWraper extends HttpServletResponseWrapper {

	protected HttpServletResponse origResponse = null;
	protected ServletOutputStream stream = null;
	protected PrintWriter writer = null;

	public GZIPResponseWraper(HttpServletResponse response) {
		super(response);
		origResponse = response;
	}

	public void finishResponse() throws IOException {
		if (writer != null)
			writer.close();
		else if (stream != null)
			stream.close();
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null) {
			throw new IllegalStateException("...");
		}
		if (stream == null) {
			stream = createOutputStream();
		}
		return stream;
	}

	protected ServletOutputStream createOutputStream() throws IOException {
		return new GZIPResponseStream(origResponse);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return writer;
		}

		if (stream != null) {
			throw new IllegalStateException("...");
		}

		stream = createOutputStream();
		writer = new PrintWriter(stream);

		return writer;
	}

	@Override
	public void flushBuffer() throws IOException {
		stream.flush();
	}

}
