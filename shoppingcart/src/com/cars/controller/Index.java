package com.cars.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet(urlPatterns = { "/home", "*.do" }, name = "Index", initParams = {
		@WebInitParam(name = "productName", value = "welcome Application") })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String appName = "My Application";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Index() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		appName = getInitParameter("productName");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && name != "") {
			//response.setContentType("text/xml");
			response.getWriter().printf(
					"<aplication>" + "<name>Hello %s</name>" + "<product>%s</product>" + "</aplication>", name,
					appName);
		} else {
			// request.getRequestDispatcher("login.jsp").forward(request, response);
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && name != "") {
			response.getWriter().printf("Hello %s", name);
		} else {
			response.sendRedirect("login.jsp");
		}
	}

}
