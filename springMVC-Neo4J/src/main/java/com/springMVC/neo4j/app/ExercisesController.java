package com.springMVC.neo4j.app;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		
		model.addAttribute("text", "ExercisesController - tutaj będą ćwiczenia do list słówek");
		
		return "exercisesController/main";
	}
}
