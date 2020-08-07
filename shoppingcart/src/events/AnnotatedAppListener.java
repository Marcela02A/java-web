package events;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class AnnotatedAppListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
			sce.getServletContext().log("AnnotatedLitener: context initialised");
		
	}
}
 