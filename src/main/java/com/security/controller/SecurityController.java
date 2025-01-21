package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	// ROLE = USER
	@GetMapping("/deepesh")
	public String deepeshGet() {
		return "deepesh";
	}

	// ROLE = USER
	@GetMapping("/akash")
	public String akashGet() {
		return "akash";
	}

	// ROLE = USER
	@GetMapping("/madhurani")
	public String madhuraniGet() {
		return "madhurani";
	}

	// ROLE = ADMIN
	@GetMapping("/siddhu")
	public String siddhuGet() {
		return "siddhu";
	}
	
	@GetMapping("/user")
	public String getUserPage() {
		return "user";
	}
}
