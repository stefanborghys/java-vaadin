package com.example.first_vaadin_eclipse_project;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Position;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("first_vaadin_eclipse_project")
public class First_vaadin_eclipse_projectUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = First_vaadin_eclipse_projectUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		final Button button = new Button("Click Me",new Button.ClickListener() {
			@Override
			public void buttonClick(final ClickEvent event) {
				layout.addComponent(new Label("Thank you for clicking"));
			}
		});
		layout.addComponent(button);
		
		Notification.show("Welcome","\nWelcome to this page",Notification.Type.HUMANIZED_MESSAGE);
		// enhanced notification, allowing HTML
		Notification notification=new Notification("<b>Welcome</b>","</br>Welcome to this page",Notification.Type.HUMANIZED_MESSAGE,true);
		notification.setDelayMsec(5000);
		notification.setPosition(Position.TOP_CENTER);
		notification.setStyleName("customNotificationStyle");
		notification.show(Page.getCurrent());
	}

}