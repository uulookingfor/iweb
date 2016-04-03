package com.uulookingfor.iservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloIwebControllor {

	@RequestMapping(value="/{userNick}", method=RequestMethod.GET)
	
	public String helloToUser(
			@PathVariable String userNick,
			@RequestParam("helloMsg") String helloMsg,
			Model model) {

		model.addAttribute("userNick", userNick);
		
		model.addAttribute("helloMsg", helloMsg);
		
		return "helloToUser";
	}
}
