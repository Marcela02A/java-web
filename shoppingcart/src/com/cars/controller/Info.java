package com.cars.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public void init() throws ServletException {

		ApplicationSetting applicationSetting = new ApplicationSetting();
		CssClass cssClass = new CssClass();
		cssClass.setName("blueUser");
		Map<String, Tab> tabs = new HashMap<>();
		tabs.put("singIn", new Tab("singIn", "#singIn"));
		tabs.put("home", new Tab("Home", "#home"));
		tabs.put("profile", new Tab("Profile", "#profile"));
		tabs.put("settings", new Tab("Settings", "#settings"));
		applicationSetting.setTabs(tabs);

		String[] tabName = { "SingIn", "Home", "Profile", "Setting" };
		// anidamos Beans
		applicationSetting.setTabName(tabName);
		applicationSetting.setFormCssClass(cssClass);
		getServletContext().setAttribute("app", applicationSetting);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InfoUser user = new InfoUser();
		user.set_name("mar");
		user.set_email("mar.ar@gmail.com");
		user.setAvatar("https://imagenmix.net/wp-content/uploads/2016/09/imagenes-bonitas.jpg");
		user.addPriority("Select All", 1);
		user.addPriority("go for a run", 3);

		try {

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");
			// pasar el bean a la pagina
			request.setAttribute("user", user);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
