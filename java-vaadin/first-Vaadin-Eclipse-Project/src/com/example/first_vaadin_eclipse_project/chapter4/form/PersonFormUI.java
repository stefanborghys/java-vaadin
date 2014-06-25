package com.example.first_vaadin_eclipse_project.chapter4.form;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

public class PersonFormUI extends UI {
	private static final long serialVersionUID = 4202174301862140634L;

	@Override
	protected void init(final VaadinRequest request) {
		final FormLayout formLayout=new FormLayout();
		final Label label=new Label("Person data:");
		formLayout.addComponent(label);
		formLayout.addComponent(createField("First name:","First name..."));
		formLayout.addComponent(createField("Last name:","Last name..."));
		formLayout.addComponent(createField("Address:","Address..."));
		final Button button=new Button("save");
		button.addClickListener(new ClickListener(){
			private static final long serialVersionUID = 3034297377312449068L;

			@Override
			public void buttonClick(final ClickEvent event) {
				// send the data
			}
			
		});
		formLayout.addComponent(button);
		setContent(formLayout);
	}
	
	private static final TextField createField(final String textFieldCaption,final String textFieldValue){
		final TextField textField=new TextField(textFieldCaption,textFieldValue);
		textField.setWidth(200.00f,Unit.PIXELS);
		textField.setRequired(true);
		textField.addFocusListener(new FocusListener(){
			private static final long serialVersionUID = -6252341282570295451L;

			@Override
			public void focus(final FocusEvent event) {
				if(textField.getValue().equals(textFieldValue)){
					textField.setValue("");
				}
			}
			
		});
		textField.addTextChangeListener(new TextChangeListener(){
			private static final long serialVersionUID = -2833372425543185788L;

			@Override
			public void textChange(final TextChangeEvent event) {
				if(textField.getValue().isEmpty()){
					textField.setValue(textFieldValue);
				}
			}
			
		});
		textField.addBlurListener(new BlurListener(){
			private static final long serialVersionUID = 6182503097665875428L;

			@Override
			public void blur(final BlurEvent event) {
				if(textField.getValue().isEmpty()){
					textField.setValue(textFieldValue);
				}
			}
			
		});
		return textField;
	}
	
	@WebServlet(value="/personform/*",asyncSupported=true)
	@VaadinServletConfiguration(productionMode=false,ui=PersonFormUI.class)
	public static class PersonFormVaadinServlet extends VaadinServlet {
		private static final long serialVersionUID = 5049797343238409902L;
		
	}

}
