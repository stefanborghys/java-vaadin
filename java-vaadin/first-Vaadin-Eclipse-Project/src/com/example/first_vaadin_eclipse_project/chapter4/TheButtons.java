package com.example.first_vaadin_eclipse_project.chapter4;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.3.2 Differentiating Between Event Sources p70
 * @author seriousbusiness
 *
 */
public class TheButtons extends CustomComponent implements Button.ClickListener {
	private static final long serialVersionUID = -7608798064812989853L;
	private final Button buttonOne,buttonTwo;
	
	public TheButtons(){
		buttonOne=new Button("First button",this);
		buttonTwo=new Button("Second button",this);
		final Layout horizontalLayout=new HorizontalLayout();
		horizontalLayout.addComponent(buttonOne);
		horizontalLayout.addComponent(buttonTwo);
		setCompositionRoot(horizontalLayout);
	}

	@Override
	public void buttonClick(final ClickEvent event) {
		if(event.getButton()==buttonOne){
			buttonOne.setCaption("Clicked one");
		}else if(event.getButton()==buttonTwo){
			buttonTwo.setCaption("Clicked two");
		}
	}

}
