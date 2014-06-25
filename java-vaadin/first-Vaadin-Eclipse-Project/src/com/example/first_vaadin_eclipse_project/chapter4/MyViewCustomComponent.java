package com.example.first_vaadin_eclipse_project.chapter4;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
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
public class MyViewCustomComponent extends CustomComponent {
	private static final long serialVersionUID = 671011673463602793L;
	private final TextField firstNameTextField,lastNameTextField;
	private final Label firstNameLabel,lastNameLabel;
	private final Button sendButton;
	
	public MyViewCustomComponent(){
		final VerticalLayout verticalLayout=new VerticalLayout();
		firstNameTextField=new TextField("Firts name");
		firstNameLabel=new Label("First name:");
		lastNameTextField=new TextField("Last name");
		lastNameLabel=new Label("Last name:");
		sendButton=new Button("Send");
		verticalLayout.addComponent(firstNameTextField);
		verticalLayout.addComponent(firstNameLabel);
		verticalLayout.addComponent(lastNameTextField);
		verticalLayout.addComponent(lastNameLabel);
		verticalLayout.addComponent(sendButton);
		setCompositionRoot(verticalLayout);
		setSizeFull();
	}

}
