package com.example.first_vaadin_eclipse_project.chapter4.session;

import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionDestroyEvent;
import com.vaadin.server.SessionDestroyListener;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.7.3 User Session p83
 * @author seriousbusiness
 *
 */
public class SessionExample extends VaadinServlet implements SessionInitListener, SessionDestroyListener{
	private static final long serialVersionUID = -2471485671993890931L;
	private static final Logger LOGGER=LoggerFactory.getLogger(SessionExample.class);
	
	@Override
	protected void servletInitialized() throws ServletException{
		super.servletInitialized();
		getService().addSessionInitListener(this);
		getService().addSessionDestroyListener(this);
	}

	@Override
	public void sessionInit(final SessionInitEvent event) throws ServiceException {
		LOGGER.debug("Session started");
	}

	@Override
	public void sessionDestroy(SessionDestroyEvent event) {
		LOGGER.debug("Session stopped");
	}
	
	

}
