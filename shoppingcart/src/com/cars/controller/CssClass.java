package com.cars.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class CssClass
 */
@WebServlet("/CssClass")
public class CssClass extends HttpServlet {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

}
