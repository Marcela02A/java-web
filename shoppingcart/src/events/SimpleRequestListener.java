package events;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class SimpleRequestListener implements ServletContextListener {

	public void requestDestroyed(ServletRequestEvent sre) {
		sre.getServletContext().log("request Destroyed");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		sre.getServletContext().log("Request Initialized");
	}
}
