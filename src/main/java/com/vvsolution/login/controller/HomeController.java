package com.vvsolution.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView home() {
//		ModelAndView mv = new ModelAndView("index.html");
		return new ModelAndView("index.html");
	}
	
	@RequestMapping("/")
	public ModelAndView index() {
//		ModelAndView mv = new ModelAndView("index.html");
		return new ModelAndView("index.html");
	}
	
}
