package com.controller.carrello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarrelloController {
	
	
	
	
	@RequestMapping(value="/cart", method = RequestMethod.GET)
	public ModelAndView cart() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cart");
		
		return mav;
	}

}
