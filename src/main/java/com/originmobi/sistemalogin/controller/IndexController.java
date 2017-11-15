package com.originmobi.sistemalogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil() {
		return "perfil";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/logout")
	public String logout() {
		return "login";
	}

}
