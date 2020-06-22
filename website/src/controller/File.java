package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.datacontract.schemas._2004._07.ApplicationServices_Entities.UserInfo;
import org.tempuri.IUserServiceProxy;

/**
 * Servlet implementation class File
 */
@WebServlet("/file")
public class File extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		IUserServiceProxy proxy = new IUserServiceProxy();
		UserInfo userInfo = proxy.getUser(name);
		response.setContentType("image/jpeg");
		response.setContentLength(userInfo.getImageContent().length); // imageBytes - image in bytes
		response.getOutputStream().write(userInfo.getImageContent());// 
		
		response.getOutputStream().close();
		response.getOutputStream().flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
