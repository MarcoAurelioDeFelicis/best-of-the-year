package it.madefelicis.best_of_the_year.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bootstrap")
public class BootstrapGreetings {
	
	@Value("${demo.colore.default}")
	private String coloreDefault;
	
	@GetMapping("/saluta")
	public String saluta(Model model) {
		
		model.addAttribute("color",coloreDefault);
		return "saluta";
		
	}
	
}
