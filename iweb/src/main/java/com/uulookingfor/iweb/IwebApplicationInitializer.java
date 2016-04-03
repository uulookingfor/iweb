package com.uulookingfor.iweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import com.uulookingfor.iweb.config.IwebConfigHolder;

/**
 * @author suxiong.sx 
 */
public class IwebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
    	
        ServletRegistration.Dynamic registration = container.addServlet(
        		IwebConfigHolder.getInst().getServletName(), 
        		new DispatcherServlet());
        
        registration.setLoadOnStartup(1);
        
        registration.addMapping(IwebConfigHolder.getInst().getServletMapping());
        
        registration.setInitParameter(
        		IwebConfigHolder.getInst().getServletContextConfigLocationKey(),
        		IwebConfigHolder.getInst().getServletContextConfigLocationVal()
        		);
        
    }
    
    

}