package com.example.first_vaadin_eclipse_project.chapter4;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.3.3 The Easy Way: Using Anonymous Classes p71
 * @author seriousbusiness
 *
 */
public class TheButtonsAnonymousClass {
	private final Button buttonOne,buttonTwo;
	
	public TheButtonsAnonymousClass(){
		buttonOne=new Button("First button");
		buttonOne.addClickListener(new Button.ClickListener(){
			private static final long serialVersionUID = 7914132944368002352L;

			@Override
			public void buttonClick(final ClickEvent event) {
				buttonOne.setCaption("Clicked one");
			}
			
		});
		buttonTwo=new Button("Second button",new Button.ClickListener() {
			private static final long serialVersionUID = 5276649985570908904L;

			@Override
			public void buttonClick(final ClickEvent event) {
				buttonOne.setCaption("Clicked two");
			}
		});
	}

}
