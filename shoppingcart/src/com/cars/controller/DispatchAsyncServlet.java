package com.cars.controller;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatch", asyncSupported = true)
public class DispatchAsyncServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		final AsyncContext ctx = req.startAsync();

		ctx.addListener(new AsyncListener() {

			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				log("DispatchAsyncServleton onComplete called, threaad id: " + Thread.currentThread().getId());

			}

			@Override
			public void onError(AsyncEvent event) throws IOException {
				log("DispatchAsyncServleton onError called, threaad id: " + Thread.currentThread().getId());

			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				log("DispatchAsyncServleton onStartAsync called, threaad id: " + Thread.currentThread().getId());

			}

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {
				log("DispatchAsyncServleton onTimeout called, threaad id: " + Thread.currentThread().getId());

			}
		});
		ctx.dispatch("/simple");
	}
}
