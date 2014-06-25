package com.example.first_vaadin_eclipse_project.chapter4.resource;

import java.io.File;

import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import com.vaadin.ui.Link;

public class FileResourceExample {
	final FileResource fileResource;
	
	public FileResourceExample(){
		final String basePath=VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
		final String vaadinPath="/WEB-INF/images/vaadin.png";
		fileResource=new FileResource(new File(basePath+vaadinPath));
	}

	/**
	 * Get a new {@link Image} containing the Vaadin Logo.
	 * @return
	 */
	public Image getVaadinImage(){
		return new Image("Vaadin Logo",fileResource);
	}
	
	/**
	 * Get a new {@link Link} to the Vaadin Logo.
	 * @return
	 */
	public Link getVaadinLink(){
		return new Link("Link to the Vaadin Logo",fileResource);
	}
}
