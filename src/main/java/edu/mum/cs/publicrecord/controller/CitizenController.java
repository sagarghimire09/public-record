package edu.mum.cs.publicrecord.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.cs.publicrecord.model.Citizen;
import edu.mum.cs.publicrecord.service.CitizenService;
import edu.mum.cs.publicrecord.service.StateService;

@Controller
public class CitizenController {
	@Autowired
	CitizenService service;
	@Autowired
	StateService stateService;
	
	@GetMapping("/citizen/list")
	public String listCustomer(Model model) {
		model.addAttribute("citizens", service.getAllCitizen());
		model.addAttribute("totalIncome", service.getNationalYearlyIncome(service.getAllCitizen()));
		return "citizen/list";
	}
	
	@GetMapping("/citizen/create")
	public String createCitizen(Model model) {
		model.addAttribute("states", stateService.getAllState());
		model.addAttribute("citizen", new Citizen());
		return "citizen/create";
	}
	
	@PostMapping("/citizen/save")
	public String saveCitizen(@Valid @ModelAttribute("citizen")Citizen citizen, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			model.addAttribute("states", stateService.getAllState());
			return "citizen/create";
		}
		service.saveCitizen(citizen);
		return "redirect:/citizen/list";
	}
	
}
