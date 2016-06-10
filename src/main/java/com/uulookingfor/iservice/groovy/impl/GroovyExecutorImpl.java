package com.uulookingfor.iservice.groovy.impl;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalDateTime;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.uulookingfor.icommon.IwebLogger;
import com.uulookingfor.icommon.serial.JsonUtil;
import com.uulookingfor.iservice.groovy.GroovyExecutor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author suxiong.sx 
 */
public class GroovyExecutorImpl implements GroovyExecutor, ApplicationContextAware{

    private ApplicationContext springCtx;
    
    private Map<String, Object> springBeans;

    private GroovyShell groovyShell;

    public Map<String,List<String>> beanMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
           throws BeansException {
    	
    	try{
    		
    		this.springCtx = applicationContext ;
    		
    		this.springBeans = springCtx.getBeansOfType(null, true, true);
    		
    		this.groovyShell = new GroovyShell(new Binding(springBeans));
    		
    	}catch(RuntimeException e){
    		
    		throw new RuntimeException("", e);
    		
    	}

    }

    public String run(String scriptText) {
    	
       String shellRet = String.format("Ip[%s]-Time[%s]\r\n", localIp(), new LocalDateTime().toString());
       
       try {
    	   
    	   Object evaluateRet = groovyShell.evaluate(scriptText);
    	   
    	   shellRet += JsonUtil.fastJsonToString(null2default(evaluateRet));
    	   
       } catch(Throwable t) {
    	   
    	   shellRet += stackTrace(t);
    	   
       }
       
       return shellRet;
       
    }


    public static String stackTrace(Throwable t) {

    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    	
    	PrintStream ps = new PrintStream(bos);
    	
    	t.printStackTrace(ps);
    	
    	return bos.toString();
    	
    }
    
    private String localIp(){
    	
    	try {
    		
			return InetAddress.getLocalHost().getHostAddress();
			
		} catch (UnknownHostException e) {

			IwebLogger.Groovy.error("UnknownHostException", e);
			
			return "";
			
		}
    	
    }
    
    private Object null2default(Object obj){
    	
    	if(obj == null){
    		return "null";
    	}
    	
    	return obj.toString();
    }
    
    public static void main(String[] args){
    	
    }

}
