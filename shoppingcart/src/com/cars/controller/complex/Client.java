package com.cars.controller.complex;

import javax.servlet.AsyncContext;

public class Client {

	private final AsyncContext asyncContext;
	private int bytesSent;

	public Client(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}

	public AsyncContext getAsyncContext() {

		return asyncContext;
	}

	public void doWork() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException el) {
			throw new RuntimeException(el);
		}
		 this.bytesSent += 10;
	}

	public int getByteSend() {

		return bytesSent;
	}

	public boolean isWorkDone() {
		return bytesSent >= 100;
	}

}
