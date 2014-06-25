package com.example.first_vaadin_eclipse_project.chapter4;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.2.2 Compositing Components p68
 * @author seriousbusiness
 *
 */
public class MyViewVerticalLayout extends VerticalLayout {
	private static final long serialVersionUID = 8116376836434624610L;
	private final TextField firstNameTextField,lastNameTextField;
	private final Label firstNameLabel,lastNameLabel;
	private final Button sendButton;

	public MyViewVerticalLayout(){
		firstNameTextField=new TextField("Firts name");
		firstNameLabel=new Label("First name:");
		lastNameTextField=new TextField("Last name");
		lastNameLabel=new Label("Last name:");
		sendButton=new Button("Send");
		addComponent(firstNameTextField);
		addComponent(firstNameLabel);
		addComponent(lastNameTextField);
		addComponent(lastNameLabel);
		addComponent(sendButton);
		setSizeFull();
		addStyleName("myViewVerticalLayout");
	}
}
