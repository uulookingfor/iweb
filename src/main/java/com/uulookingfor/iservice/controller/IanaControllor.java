package com.uulookingfor.iservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uulookingfor.iservice.groovy.GroovyExecutor;

/**
 * @author suxiong.sx 
 */
@Controller
public class IanaControllor {

	@Autowired
	private GroovyExecutor groovyExecutor;
	
	@RequestMapping(value="/iana", method=RequestMethod.GET)
	public String showPage(Model model) {

		return "iana";
		
	}
	
	@RequestMapping(value="/iana", method=RequestMethod.POST)
	public String showIanaResult(String scriptText, Model model){
		
		model.addAttribute("scriptText", scriptText);
		model.addAttribute("result", groovyExecutor.run(scriptText));
		
		return "iana";
		
	}
	
}
