package com.ksign.access.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/audit")
public class AuditController {
	
	@RequestMapping(value = "/auditList.do", method = RequestMethod.GET)
	public ModelAndView accessLog(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView();
	}
}
