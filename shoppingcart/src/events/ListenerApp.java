package events;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerApp implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		ServletContext ctx = sce.getServletContext();
		ctx.log("Context initialised");
		String productName = sce.getServletContext().getInitParameter("ProductName");
		ctx.log(("context inicialised" + productName));

	}

}
