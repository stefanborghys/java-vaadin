package com.example.first_vaadin_eclipse_project.chapter4.messages;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.6 Notifications p78
 * @author seriousbusiness
 *
 */
public class NotificationExample extends UI {
	private static final long serialVersionUID = 54290363413577097L;

	@Override
	protected void init(final VaadinRequest request) {
		// simple
		Notification.show("Welcome","\nWelcome to this page",Notification.Type.HUMANIZED_MESSAGE);
		// enhanced notification, allowing HTML and custom CSS style
		Notification notification=new Notification("<b>Welcome</b>","</br>Welcome to this page",Notification.Type.HUMANIZED_MESSAGE,true);
		notification.setDelayMsec(5000);
		notification.setPosition(Position.TOP_CENTER);
		notification.setStyleName("customNotificationStyle"); // added in WebContent/VAADIN/themes/first_vaadin_eclipse_project/styles.scss
		notification.show(Page.getCurrent());
	}

}
