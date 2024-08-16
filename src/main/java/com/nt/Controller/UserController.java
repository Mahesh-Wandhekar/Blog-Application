package com.nt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.Binding.RegisterBinding;
import com.nt.Services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	HttpSession session;
	
	@Autowired
	private UserService service;

	@GetMapping("reg")
	public String reg(RegisterBinding binding, Model model) {

		model.addAttribute("register", binding);
		return "register";
	}

	@PostMapping("reg")
	public String regload(@ModelAttribute("register") RegisterBinding binding, Model model) {
		System.out.println(binding);
		boolean status = service.register(binding);
		if (status) {
			model.addAttribute("sucmsg", "Register Successfully...!");
		} else {
			model.addAttribute("errmsg", "Register Failed...!");
		}
		return "register";
	}

	@GetMapping("login")
	public String login(RegisterBinding binding, Model model) {

		model.addAttribute("login", binding);
		return "login";
	}
	
	@PostMapping("login")
	public String loginload( @ModelAttribute ("login")RegisterBinding binding, Model model) {

		boolean status=service.login(binding);
		if(status) {
			return "redirect:/userDashboard";
			}		
		model.addAttribute("errmsg","Invalid User Details...!");
		return "login";
	}
}
