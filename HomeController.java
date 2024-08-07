package com.example.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.servicee.RegisterService;

@Controller
public class HomeController {

    @Autowired
    private RegisterService registerService;
	
	@GetMapping("/")
    public String index() {
        return "index"; // This returns the index.html file
    }

    @GetMapping ("/register")
    	public String showRegistrationPage(Model model) {
    	model.addAttribute("user", new User());
    		return "register"; //This returns the register.html file
    	}
    @PostMapping ("/register")
    public String register(@ModelAttribute("user") @Validated User user, BindingResult result) {
    	if (result.hasErrors()) {
    		return "register";
    	}
    	registerService.register(user);
    	    	
    	return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // This returns the login.html file
    }

    @GetMapping("/products")
    public String viewProducts() {
        return "products"; // This returns the products.html file
    }
}
