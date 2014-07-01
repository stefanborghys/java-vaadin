package com.example.first_vaadin_eclipse_project.chapter5.locale;

import java.util.Locale;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.InlineDateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 5 - User Interface Components</br>
 * 5.3.5 Locale p101
 * @author seriousbusiness
 *
 */
public class LocaleExample extends UI {
	private static final long serialVersionUID = -6679909973167561840L;

	@Override
	protected void init(final VaadinRequest request) {
		final VerticalLayout layout=new VerticalLayout();
		// ComboBox
		final ComboBox localeComboBox=createLocaleComboBox("Language:",Locale.ENGLISH,getLocale());
		layout.addComponent(localeComboBox);
		// Label
		final Label localeCode=new Label("");
		layout.addComponent(localeCode);
		// Date field
		final InlineDateField inlineDateField=new InlineDateField("Calendar in selected language:");
		inlineDateField.setResolution(Resolution.DAY);
		layout.addComponent(inlineDateField);
		// Change locale after selection changed
		localeComboBox.addValueChangeListener(new Property.ValueChangeListener() {
			private static final long serialVersionUID = -7722087012282876588L;

			@Override
			public void valueChange(final ValueChangeEvent event) {
				final Locale locale=(Locale) localeComboBox.getValue();
				inlineDateField.setLocale(locale);
				localeCode.setValue("Locale code: "+locale.getLanguage()+" - "+locale.getCountry());
			}
		});
		layout.setImmediate(true);
		setContent(layout);
	}
	
	/**
	 * Create a new ComboBox containing all possible languages.
	 * @param caption the comboBox's caption
	 * @param defaultLocale used to show the languages in the correct language
	 * @param currentLocale used to select a language by default
	 * @return a new ComboBox containing all available languages
	 */
	private static final ComboBox createLocaleComboBox(final String caption,final Locale defaultLocale,final Locale currentLocale){
		final ComboBox comboBox=new ComboBox(caption){
			private static final long serialVersionUID = 1L;
			
			/**
			 * Set the locale when the ComboBox is attached to the UI.</br>
			 * This needs to be done after the Component is attached,</br>
			 * otherwise getLocale() returns <code>null</code>.</br>
			 * </br>
			 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
			 * Chapter 5 - User Interface Components</br>
			 * 5.3.5 Locale p102
			 */
			@Override
			public void attach(){
				super.attach();
				setValue(getLocale());
			}
		};
		// Add all locales to the comboBox
		for(final Locale locale : Locale.getAvailableLocales()){
			comboBox.addItem(locale);
			comboBox.setItemCaption(locale,locale.getDisplayName(defaultLocale));
			// Set the current locale selected
			if(locale.equals(currentLocale)){
				comboBox.setValue(locale);
			}
		}
		return comboBox;
	}

}
