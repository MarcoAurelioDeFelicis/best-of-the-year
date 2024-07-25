package it.madefelicis.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.madefelicis.best_of_the_year.model.User;

@Controller
public class indexController {
	
	@GetMapping("/utente")
	public String users (Model model) {
		
		User io = new User();
		io.setName("Marco");
		io.setSurname("De Felicis");
		
		model.addAttribute("user", io);
		
		return "users";
	}
}
