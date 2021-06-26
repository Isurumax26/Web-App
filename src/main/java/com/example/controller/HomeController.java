package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Product;


@Controller 
public class HomeController {
	
	
	Product penguin= new Product(1);

	Product horseShoe = new Product(2);
	
	List<Double> penguEars = new ArrayList<>();
	List<Double> horseShoes = new ArrayList<>();
	
	
	
	
	
	public void tablePrice() {
		for(int i=1; i<51 ; i++) {
			penguEars.add(Math.round(penguin.calPrice(i)*100.0)/100.0);
			horseShoes.add(horseShoe.calPrice(i));	
		}	
	}
	
	
	@GetMapping("/home")
	public String homePage(Model model) {
		tablePrice();
		//System.out.println(penguEars);
		//System.out.println(horseShoe);
		//System.out.println(calPrice(1, 1));
		//System.out.println(calPrice(2, 6));
		model.addAttribute("penguins", penguEars);
		model.addAttribute("horseshoes",horseShoes);
		return "home";
		
	}
	
	@PostMapping("/custom")
	public String customPage(@ModelAttribute Product product, Model model) {
		double total = product.calPrice(product.getAmount());
		model.addAttribute("total", total);
		model.addAttribute("amount", product.getAmount());
		model.addAttribute("id", product.getId());
		return "custom";
	}
	
	@GetMapping("/custom")
	public String otherAmount(Model model) {
		model.addAttribute("product", new Product());		
		return "custom";
	}
	

}
