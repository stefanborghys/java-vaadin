package com.example.first_vaadin_eclipse_project.chapter5.field;

import java.util.Date;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.validator.CompositeValidator;
import com.vaadin.data.validator.CompositeValidator.CombinationMode;
import com.vaadin.data.validator.DateRangeValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.NullValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 5 - User Interface Components</br>
 * 5.4.5 Field Validation p110
 * @author seriousbusiness
 *
 */
public class FieldValidationExample extends UI {
	private static final long serialVersionUID = -352385926573588733L;

	@SuppressWarnings("deprecation")
	@Override
	protected void init(VaadinRequest request) {
		// Title
		final Label title=new Label("<b>Account details</b>",ContentMode.HTML);
		// First name
		final TextField firstName=new TextField("First name:");
		firstName.setInputPrompt("first name...");
		firstName.setDescription("first name");
		firstName.setRequired(true);
		firstName.setRequiredError("The first name is mandatory!");
		firstName.setMaxLength(50); // Prevents from entering a longer name, automatically truncated on the server-side
		final CompositeValidator compositeValidator=new CompositeValidator(CombinationMode.AND,"The first name cannot be null or empty");
		compositeValidator.addValidator(new NullValidator("The first name cannot be null!",false));
		compositeValidator.addValidator(new StringLengthValidator("The first name has to have at least 2",2,50,false));
		firstName.addValidator(compositeValidator);
		firstName.setImmediate(true); // Validated immediately when focus leaves field
		firstName.setValidationVisible(true);
		// Last name
		final TextField lastName=new TextField("Last name:");
		lastName.setInputPrompt("last name...");
		lastName.setDescription("last name");
		lastName.setRequired(true);
		lastName.setRequiredError("The last name is mandatory!");
		lastName.setMaxLength(50); // Prevents from entering a longer name, automatically truncated on the server-side
		lastName.addValidator(new StringLengthValidator("The last name has to have at least 2 characters",2,50,false));
		lastName.setImmediate(true); // Validated immediately when focus leaves field
		lastName.setValidationVisible(true);
		// Sex
		final OptionGroup sexes=new OptionGroup("Sex:"); // p141
		sexes.setDescription("sexes");
		sexes.setRequired(true);
		sexes.setRequiredError("A sex is mandatory!");
		sexes.setMultiSelect(false);
		sexes.setNewItemsAllowed(false);
		sexes.addItem("male");
		sexes.addItem("female");
		sexes.addItem("other");
		sexes.setItemCaption("male","Male");
		sexes.setItemCaption("female","Female");
		sexes.setItemCaption("other","Other");
		// Password
		final PasswordField password=new PasswordField("Password:"),
			confirmedPassword=new PasswordField("Confirm password:");
		password.setDescription("password");
		password.setRequired(true);
		password.setRequiredError("The password is mandatory!");
		password.setMaxLength(25);
		password.setImmediate(true); // Validated immediately when focus leaves field
		password.setValidationVisible(true);
		password.addTextChangeListener(new TextChangeListener(){
			private static final long serialVersionUID = -3110622268264445281L;

			@Override
			public void textChange(final TextChangeEvent event) {
				confirmPassword(password,confirmedPassword);
			}
			
		});
		// Password confirmation
		confirmedPassword.setDescription("confirmed password");
		confirmedPassword.setRequired(true);
		confirmedPassword.setRequiredError("The password is mandatory!");
		confirmedPassword.setMaxLength(25);
		confirmedPassword.setImmediate(true); // Validated immediately when focus leaves field
		confirmedPassword.setValidationVisible(true);
		confirmedPassword.addTextChangeListener(new TextChangeListener(){
			private static final long serialVersionUID = -3110622268264445281L;

			@Override
			public void textChange(final TextChangeEvent event) {
				confirmPassword(password,confirmedPassword);
			}
			
		});
		// Email
		final TextField email=new TextField("Email:");
		email.setInputPrompt("email...");
		email.setDescription("email");
		email.setRequired(true);
		email.setRequiredError("The email is mandatory!");
		email.addValidator(new EmailValidator("The email address is invalid"));
		email.setImmediate(true); // Validated immediately when focus leaves field
		email.setValidationVisible(true);
		// Date of birth
		final InlineDateField dateOfBirth=new InlineDateField("Date of birth:");
		dateOfBirth.setDescription("date of birth");
		dateOfBirth.setRequired(true);
		dateOfBirth.setRequiredError("The date of birth is mandatory!");
		dateOfBirth.setDateFormat("dd-MM-yyyy"); // Custom date format p127
		dateOfBirth.setResolution(Resolution.DAY); // Lowest visible component p131
		final Date maxDate=new Date(),minDate=new Date();
		minDate.setYear(maxDate.getYear()-100);
		dateOfBirth.addValidator(new DateRangeValidator("The date of birth cannot be in the future or older than 100 years",minDate,maxDate,Resolution.YEAR));
		dateOfBirth.setImmediate(true); // Validated immediately when focus leaves field
		dateOfBirth.setValidationVisible(true);
		// Description
		final TextArea description=new TextArea("Description:");
		description.setDescription("description");
		description.setRequired(false);
		description.setMaxLength(300);
		description.setRows(5); // Number of visible rows
		description.setWordwrap(true); // Wrap lines which are longer than the width of this TextArea
		// Save
		final Button save=new Button("Save",new Button.ClickListener() {
			private static final long serialVersionUID = -79087110623486636L;

			@Override
			public void buttonClick(final ClickEvent event) {
				try{
					// Explicit validation! p112
					firstName.validate();
					//firstName.commit(); // Used in combination with Field buffering
					lastName.validate();
					//lastName.commit(); // Used in combination with Field buffering
					sexes.validate();
					email.validate();
					//email.commit(); // Used in combination with Field buffering
					dateOfBirth.validate();
					//dateOfBirth.commit(); // Used in combination with Field buffering
				}catch(final InvalidValueException e){
					Notification.show("One or more fields are incorrect!");
				}
			}
		});
		// Accept terms
		final CheckBox terms=new CheckBox("Accept terms:");
		terms.addValueChangeListener(new ValueChangeListener(){
			private static final long serialVersionUID = 2596589552163997664L;

			@Override
			public void valueChange(final ValueChangeEvent event) {
				save.setEnabled(terms.getValue());
			}
			
		});
		// Layout
		final FormLayout layout=new FormLayout();
		layout.addComponent(title);
		layout.addComponent(firstName);
		layout.addComponent(lastName);
		layout.addComponent(sexes);
		layout.addComponent(password);
		layout.addComponent(confirmedPassword);
		layout.addComponent(email);
		layout.addComponent(dateOfBirth);
		layout.addComponent(description);
		layout.addComponent(terms);
		layout.addComponent(save);
		setContent(layout);
	}
	
	private static final void confirmPassword(final PasswordField password,final PasswordField confirmedPassword){
		if(confirmedPassword.getValue().equals(password.getValue())){
			confirmedPassword.setStyleName("validConfirmedPassword");
		}else{
			confirmedPassword.setStyleName("invalidConfirmedPassword");
		}
	}

}
