package com.uniovi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.entitites.Operator;
import com.uniovi.services.OperatorService;

@Controller
public class HomeController {
	@Autowired
	private OperatorService operatorService;

	@RequestMapping("/")
	public String getHome(Model model) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		Operator op  = operatorService.getOperatorByEmail(username);
		model.addAttribute("operator", op);
		return "home";
	}
	

	
}
