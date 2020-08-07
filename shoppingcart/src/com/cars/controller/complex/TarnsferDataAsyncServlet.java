package com.cars.controller.complex;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/download", asyncSupported = true)
public class TarnsferDataAsyncServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

		AsyncContext asyncContext = req.startAsync();
		asyncContext.setTimeout(15 * 60 * 1000);
		ClientTransfer.addClient(new Client(asyncContext));

	}

}
