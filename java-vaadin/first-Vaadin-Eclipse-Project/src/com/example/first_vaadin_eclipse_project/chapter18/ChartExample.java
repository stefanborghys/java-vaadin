package com.example.first_vaadin_eclipse_project.chapter18;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Book of Vaadin - Vaadin 7 Edition - 2nd Revision</br>
 * Chapter 18 - Vaadin Charts</br>
 * 18.1 Overview p443
 * @author seriousbusiness
 *
 */
public class ChartExample extends UI {
	private static final long serialVersionUID = -7081535820648714705L;

	@Override
	protected void init(final VaadinRequest request) {
		// Chart
		final Chart chart=new Chart(ChartType.BAR);
		chart.setWidth("400px");
		chart.setHeight("300px");
		// Configuration
		final Configuration configuration=chart.getConfiguration();
		configuration.setTitle("Chart example");
		configuration.setSubTitle("Planets and their diameters");
		configuration.getLegend().setEnabled(true);
		// Data
		final ListSeries series=new ListSeries("Diameter");
		series.setData(3000,2300,5000,1200,143000,125000,51150,49500);
		configuration.addSeries(series);
		// Axis
		final XAxis xaxis=new XAxis();
		xaxis.setCategories("Mercury","Venus","Earth","Moon","Mars","Jupiter","Neptune","Uranus");
		xaxis.setTitle("Planet");
		final YAxis yaxis=new YAxis();
		yaxis.setTitle("Diameter");
		yaxis.getLabels().setFormatter("function() {return Math.floor(this.value/1000) + \'Mm\';}");
		yaxis.getLabels().setStep(2);
		// Layout
		final VerticalLayout layout=new VerticalLayout();
		layout.addComponent(chart);
		setContent(layout);
	}

}
