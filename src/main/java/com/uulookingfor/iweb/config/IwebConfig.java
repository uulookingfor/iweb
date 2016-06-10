package com.uulookingfor.iweb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

import com.uulookingfor.iweb.domain.IwebConstants;

/**
 * @author suxiong.sx 
 */
public class IwebConfig implements IwebConstants{

	private boolean inited = false;
	
	public synchronized void init() throws Exception{
		
		if(inited){
			return;
		}
		
		//init here...
		initFrom(configFilePath, IwebConfigHolder.getInst());
		
		inited = true;
		
	}

	
	private IwebConfigHolder initFrom(String configFilePath, IwebConfigHolder inst) throws Exception{
		
		Properties props = new Properties();
		
		InputStream inStream = getClass().getResourceAsStream(configFilePath);
		
		try {
			
			props.load(inStream);
			
		} catch (IOException e) {
			
			throw e;
			
		};
		
		
		inStream.close();
		
		BeanUtils.populate(inst, toMap(props));
		
		return inst;
	}
	
	private Map<String, Object> toMap(Properties props){
		
		Map<String, Object> ret = new HashMap<String, Object>();
		
		for(Entry<Object, Object> entry : props.entrySet()){
			
			ret.put(String.valueOf(entry.getKey()), entry.getValue());
			
		}
		
		return ret;
	}
	
}
