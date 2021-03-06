package com.ksign.access.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
	public ModelAndView accessLog(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		String x = request.getParameter("x");

		if(x != null) mav.addObject("x", x);

		return mav;
	}
}
