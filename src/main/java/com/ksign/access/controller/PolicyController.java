package com.ksign.access.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/policy")
public class PolicyController {

	private Logger log = Logger.getLogger(getClass());
	@RequestMapping(value = "/{serviceId}", method = RequestMethod.GET)
	public ModelAndView accessLog(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();

		String x = request.getParameter("x");

		if(x != null) mav.addObject("x", x);

		return mav;
	}
}
