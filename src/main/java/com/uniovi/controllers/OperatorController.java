package com.uniovi.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.entitites.Incident;
import com.uniovi.entitites.Operator;
import com.uniovi.services.IncidentsService;
import com.uniovi.services.OperatorService;

@Controller
public class OperatorController {

	@Autowired
	private OperatorService operatorService;
	
	@Autowired
	private IncidentsService incidentService;
	
	

	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}

	@RequestMapping("/operator/list")
	public String getIncidentsList(Model model) {
		//model.addAttribute("indicentsList", operatorService.getIncidentsFromUser(getActiveUser()));
		return "operator/listIncidents";
	}
	
	@RequestMapping("/dashboard/list")
	public String getToList() {
		return "redirect:/incident/list";
	}
	
	@RequestMapping("/incident/list")
	public String list(Model model, Pageable pageable) {
		
		Page<Incident> incidents = new PageImpl<Incident>(new LinkedList<Incident>());
		incidents = this.incidentService.listAllIncidents(pageable);
		model.addAttribute("incidents", incidents.getContent());
		model.addAttribute("page", incidents);
		return "/incident/list";
	}
	
	
	

	private Operator getActiveUser() {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		return operatorService.getOperatorByEmail(username);
	}

}
