package com.example.first_vaadin_eclipse_project.chapter4.messages;

import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.5.3 Handling Uncaught Exceptions p77
 * @author seriousbusiness
 *
 */
public class UncaugthExceptionsExample extends UI {
	private static final long serialVersionUID = 5650884615962858315L;
	private Layout layout;

	@Override
	protected void init(final VaadinRequest request) {
		layout=new VerticalLayout();
		final Button button=new Button("Throw a NullPointerException!",new Button.ClickListener(){
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(final ClickEvent event) {
				((String)null).length(); // throws a NullPointerException
			}
			
		});
		layout.addComponent(button);
		// Create a custom ErrorHandler
		getCurrent().setErrorHandler(new DefaultErrorHandler(){
			private static final long serialVersionUID = -4673224429225826940L;

			@Override
			public void error(final com.vaadin.server.ErrorEvent event){
				String cause="<b>The click failed because:</b></br>";
				for(Throwable throwable=event.getThrowable(); throwable!=null; throwable=throwable.getCause()){
					if(throwable.getCause()==null){
						cause+=throwable.getClass().getName()+"</br>";
					}
				}
				// find the component that caused the error
				AbstractComponent abstractComponent=findAbstractComponent(event);
				if(abstractComponent instanceof Button){
					abstractComponent.setCaption(">>It was me who triggered this error<<");
				}
				layout.addComponent(new Label(cause,ContentMode.HTML));
				doDefault(event);
			}
		});
	}

}
