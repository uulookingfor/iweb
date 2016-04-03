package com.uulookingfor.iweb.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author suxiong.sx 
 */
public class IwebConfigHolder {
	
	@Getter private static IwebConfigHolder inst = new IwebConfigHolder();
	
	@Getter @Setter private String servletName = "dispatcher";
	
	@Getter @Setter private String servletMapping = "/*";
	
	@Getter @Setter private String servletContextConfigLocationKey = "contextConfigLocation";
	
	@Getter @Setter private String servletContextConfigLocationVal = "classpath:spring/spring-servlet-config.xml";
	
	
}
