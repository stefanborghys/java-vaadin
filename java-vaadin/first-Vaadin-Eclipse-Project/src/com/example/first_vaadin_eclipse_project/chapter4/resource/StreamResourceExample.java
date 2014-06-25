package com.example.first_vaadin_eclipse_project.chapter4.resource;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.vaadin.server.StreamResource;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 4 - Writing a Server-Side Web Application</br>
 * 4.4.5 Stream Resources p74
 * @author seriousbusiness
 *
 */
public class StreamResourceExample implements StreamResource.StreamSource {
	private static final long serialVersionUID = -8196928861813334190L;
	private ByteArrayOutputStream byteArrayOutputStream;
	private int reloads=0;
	
	@Override
	public InputStream getStream(){
		final BufferedImage bufferedImage=new BufferedImage(200,200,BufferedImage.TYPE_INT_RGB);
		final Graphics graphics=bufferedImage.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0,0,200,200);
		graphics.setColor(Color.YELLOW);
		graphics.fillOval(25,25,150,150);
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0,0,199,199);
		graphics.setColor(Color.BLACK);
		graphics.drawString("Reloads="+reloads++,75,100);
		try{
			byteArrayOutputStream=new ByteArrayOutputStream();
			ImageIO.write(bufferedImage,"png",byteArrayOutputStream); // write image to a buffer
			return new ByteArrayInputStream(byteArrayOutputStream.toByteArray()); // return a stream from the buffer
		}catch(final IOException e){
			return null;
		}
	}

}
