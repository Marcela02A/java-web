package com.cars.controller;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple", asyncSupported = true)
public class FirsrtAsyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		log("FirstAsyncServlet in 'Do Get' thread id:" + Thread.currentThread().getId());
		final AsyncContext cxt = req.startAsync();

		cxt.addListener(new AsyncListener() {

			@Override
			public void onTimeout(AsyncEvent event) throws IOException {

			}

			@Override
			public void onStartAsync(AsyncEvent event) throws IOException {
				log("FirstAsyncServlet onStrart called, threadid: " + Thread.currentThread().getId());
			}

			@Override
			public void onError(AsyncEvent event) throws IOException {
				log("FirstAsyncServlet onError called, threadid: " + Thread.currentThread().getId());

			}

			@Override
			public void onComplete(AsyncEvent event) throws IOException {
				log("FirstAsyncServlet onComplete called, threadid: " + Thread.currentThread().getId());
			}
		});

		cxt.start(() -> {
			try {
				log("FirstAsyncServlet in 'start', thread id: " + Thread.currentThread().getId());

				cxt.getResponse().getWriter().write(MessageFormat.format("<h1> Processing task in bgt_id:[{0}]</h1>",
						Thread.currentThread().getId()));
			} catch (Exception e) {
				log("FirstAsyncServlet problem processing task", e);
			}
			cxt.complete();
		});

	}

}
