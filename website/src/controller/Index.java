package controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datacontract.schemas._2004._07.ApplicationServices_Entities.UserInfo;
import org.tempuri.IUserServiceProxy;

/**
 * Servlet implementation class index
 */
@WebServlet(urlPatterns = { "/home", "*.do" }, name = "Index", initParams = {
		@WebInitParam(name = "productName", value = "welcome Application") })
public class Index extends HttpServlet {
	String appName = "My Application";

	@Override
	public void init() throws ServletException {
		appName = getInitParameter("productName");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name != null && name != "") {
			response.setContentType("text/xml");
			response.getWriter().printf(
					"<aplication>" + "<name>Hello %s</name>" + "<product>%s</product>" + "</aplication>", name,
					appName);
		} else {
			// request.getRequestDispatcher("login.jsp").forward(request, response);
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
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
