package com.example.Mymini.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Mymini.model.UserDTO;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String toIndex(HttpSession session, Model model) {
		UserDTO login=(UserDTO)session.getAttribute("login");
		model.addAttribute("login", login);
		
		return "main";
	}
}