package edu.mondragon.intialization;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import edu.mondragon.configuration.AppConfiguration;

public class AppInitialization implements WebApplicationInitializer {
	 public void onStartup(ServletContext container) throws ServletException {
	 
	        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	         
	        ctx.register(AppConfiguration.class);
	 
	        container.addListener(new ContextLoaderListener(ctx));
	 
	        ServletRegistration.Dynamic servlet = container.addServlet(
	          "dispatcher", new DispatcherServlet(ctx));
	        servlet.setLoadOnStartup(1);
	        servlet.addMapping("/");
	    }
	}