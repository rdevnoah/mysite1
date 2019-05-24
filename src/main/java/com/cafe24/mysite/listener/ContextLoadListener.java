package com.cafe24.mysite.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoadListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent)  {
		
		String contextConfigLocation = servletContextEvent.getServletContext().getInitParameter("contextConfigLocation");
		System.out.println("Container starts....");
		System.out.println("contextConfigLocation:" + contextConfigLocation);
	}

	public void contextDestroyed(ServletContextEvent arg0)  {
    	
    }

	
}
