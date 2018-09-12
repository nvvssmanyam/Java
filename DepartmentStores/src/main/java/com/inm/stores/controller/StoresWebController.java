package com.inm.stores.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoresWebController {
	@GetMapping("/home")
	public ModelAndView loginMessage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("welcome");
		return model;
	}
}
