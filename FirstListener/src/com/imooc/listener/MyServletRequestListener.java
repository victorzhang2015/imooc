package com.imooc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	public void requestDestroyed(ServletRequestEvent servletrequestevent) {
		System.out.println("requestDestroyed ");
	}

	public void requestInitialized(ServletRequestEvent servletrequestevent) {
		String name = servletrequestevent.getServletRequest().getParameter("name");
		System.out.println("requestInitialized name:"+name);
	}

}
