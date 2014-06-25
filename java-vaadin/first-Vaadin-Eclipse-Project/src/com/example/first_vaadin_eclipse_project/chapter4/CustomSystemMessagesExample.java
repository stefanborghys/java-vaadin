package com.example.first_vaadin_eclipse_project.chapter4;

import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import com.vaadin.server.VaadinServlet;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.5.2 Customizing System Messages p76</br>
 * </br>
 * System messages:</br>
 * Notifications that indicate a major invalid state in an application usually requires restarting.</br>
 * <ul>
 * <li>sessionExpired</li>
 * <li>communicationError</li>
 * <li>authenticationError</li>
 * <li>internalError</li>
 * <li>outOfSync</li>
 * <li>cookiesDisabled</li>
 * </ul>
 * @author seriousbusiness
 *
 */
public class CustomSystemMessagesExample extends VaadinServlet {
	private static final long serialVersionUID = -4805418783828099001L;

	public CustomSystemMessagesExample(){
		getService().setSystemMessagesProvider(new SystemMessagesProvider(){
			private static final long serialVersionUID = 8439628638655564687L;

			@Override
			public SystemMessages getSystemMessages(final SystemMessagesInfo systemMessagesInfo) {
				final CustomizedSystemMessages customizedSystemMessages=new CustomizedSystemMessages();
				/*
				 * CommunicationError:
				 * An unspecified communication problem between the Vaadin Client-Side Engine and the application server.
				 * The server may be unavailable or there is some other problem.
				 */
				customizedSystemMessages.setCommunicationErrorCaption("Communication error");
				customizedSystemMessages.setCommunicationErrorMessage("This is bad");
				customizedSystemMessages.setCommunicationErrorNotificationEnabled(true);
				customizedSystemMessages.setCommunicationErrorURL("http://www.vaadin.com");
				return customizedSystemMessages;
			}
			
		});
	}

}
