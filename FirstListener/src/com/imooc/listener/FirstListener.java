package com.imooc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FirstListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletcontextevent) {
		String initParam = servletcontextevent.getServletContext().getInitParameter("initParam");
		System.out.println("contextInitialized : initParam = "+initParam);
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		System.out.println("contextDestroyed");
	}

}
