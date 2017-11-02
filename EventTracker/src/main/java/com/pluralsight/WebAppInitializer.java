package com.pluralsight;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletCxt) throws ServletException {
		
		// Load Spring web application configuration
		WebApplicationContext cxt = getContext();
		
		//servletCxt.addListener(new ContextLoaderListener(cxt));
		// Create DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(cxt);
		
		// Register and map the Servlet
		ServletRegistration.Dynamic dispatcher = servletCxt.addServlet("DispatcherServlet", servlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.html");
		dispatcher.addMapping("*.pdf");
		dispatcher.addMapping("*.css");
		dispatcher.addMapping("*.json");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext cxt = new AnnotationConfigWebApplicationContext();
		cxt.register(WebAppConfig.class);
		cxt.refresh();
		
		return cxt;
	}

}
