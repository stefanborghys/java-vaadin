package com.example.first_vaadin_eclipse_project.chapter4;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.3.1 Implementing a Listener in a Regular Class p70
 * @author seriousbusiness
 *
 */
public class MyCompositeCustomComponent extends CustomComponent implements Button.ClickListener {
	private static final long serialVersionUID = 2126326938004689498L;
	private final Button button;
	
	public MyCompositeCustomComponent(){
		final Layout horizontalLayout=new HorizontalLayout();
		button=new Button("Do not push this!");
		button.addClickListener(this);
		horizontalLayout.addComponent(button);
		setCompositionRoot(horizontalLayout);
	}

	@Override
	public void buttonClick(final ClickEvent event) {
		button.setCaption("Do not push this button again!");
	}

}
