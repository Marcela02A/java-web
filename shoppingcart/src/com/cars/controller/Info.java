package com.cars.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "productName", value = "welcome Application") })
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Info() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InfoUser user = new InfoUser();
		user.set_name("mar");
		user.set_email("mar.ar@gmail.com");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
		// pasar el bean a la pagina
		request.setAttribute("user", user);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
