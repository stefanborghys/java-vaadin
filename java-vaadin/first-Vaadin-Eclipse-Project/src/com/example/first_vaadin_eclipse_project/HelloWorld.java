package com.example.first_vaadin_eclipse_project;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class HelloWorld extends UI {
	private static final long serialVersionUID = -8538174828765652896L;

	@Override
	protected void init(final VaadinRequest request) {
		final VerticalLayout verticalLayout=new VerticalLayout();
		verticalLayout.setSizeFull(); // Use the entire window
		setContent(verticalLayout);
		verticalLayout.addComponent(new Label("Hello World!"));
		final Layout horizontalLayout=createHorizontalLayout();
		verticalLayout.addComponent(horizontalLayout);
		verticalLayout.setExpandRatio(horizontalLayout,1);
	}
	
	private Layout createHorizontalLayout(){
		final HorizontalLayout horizontalLayout=new HorizontalLayout();
		horizontalLayout.setSizeFull(); // Use the entire window
		final Tree tree=new Tree("Hello Tree");
		horizontalLayout.addComponent(tree);
		final Table table=new Table("Hello Table");
		table.setSizeFull();
		horizontalLayout.addComponent(table);
		horizontalLayout.setExpandRatio(table,1);
		return horizontalLayout;
	}

}
