package com.cars.controller.filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

public class GZIPResponseStream extends ServletOutputStream {

	protected ByteArrayOutputStream baos = null;
	protected GZIPOutputStream gzipstream = null;
	protected boolean closed = false;
	protected HttpServletResponse response = null;
	protected ServletOutputStream output = null;

	public GZIPResponseStream(HttpServletResponse response) throws IOException {
		super();
		this.response = response;
		this.output = response.getOutputStream();
		baos = new ByteArrayOutputStream();
		gzipstream = new GZIPOutputStream(baos);
	}

	public void close() throws IOException {
		if (closed) {
			throw new IOException("This output stream tha already been closed");
		}
		gzipstream.finish();
		byte[] bytes = baos.toByteArray();

		response.addHeader("content-Encoding", "gzip");
		response.addHeader("Content-Lenght", Integer.toString(bytes.length));

		output.write(bytes);
		output.flush();
		output.close();

		closed = true;

	}

	@Override
	public void write(int b) throws IOException {
		gzipstream.write(b);
	}

	public void write(byte b[], int off, int len) throws IOException {
		if (closed) {
			throw new IOException("Cannot write to a closed output stream");
		}
		gzipstream.write(b, off, len);
	}

	@Override
	public boolean isReady() {

		return false;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {

	}

}
