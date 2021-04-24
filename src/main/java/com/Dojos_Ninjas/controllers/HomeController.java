package com.Dojos_Ninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Dojos_Ninjas.models.Dojo;
import com.Dojos_Ninjas.models.Ninja;
import com.Dojos_Ninjas.services.DojoNinja_Services;


@Controller
public class HomeController {
	
	private DojoNinja_Services dnServ;
	
	public HomeController(DojoNinja_Services dnServ) {
		super();
		this.dnServ = dnServ;
	}

	//Show all of our Dojos
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos", this.dnServ.getAllDojos());
		return "index.jsp";
	}
	
	//We can show one Dojo and its Ninjas
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo myDojo = this.dnServ.getDojo(id);
		model.addAttribute("thisDojo", myDojo);
		return "oneDojo.jsp";
	}
	
	
	//Form to create Dojo
	@GetMapping("/dojo/new")
	public String dojo(@ModelAttribute("addDojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	//Create a Dojo
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("addDojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			this.dnServ.create(dojo);
		}
		return "redirect:/";
	}
	//Form to create Ninja
	@GetMapping("/ninja/new")
	public String ninja(@ModelAttribute("addNinja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", this.dnServ.getAllDojos());
		return "newNinja.jsp";
	}
	//Create a Ninja
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("addNinja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
		}else {
			this.dnServ.create(ninja);
		}
		return "redirect:/";
	}
}
