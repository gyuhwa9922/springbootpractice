package com.example.Mymini.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Mymini.model.UserDTO;
import com.example.Mymini.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	public String convertSha2(String password) {
		String converted = null;
		StringBuilder builder = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes("UTF-8"));
			builder = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				builder.append(String.format("%02x", 255 & hash[i]));
				// -> 절댓값으로 바꾸는 과정
			}
			converted = builder.toString();

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return converted;

	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "user/register";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerLogic(UserDTO u) {
		u.setPassword(convertSha2(u.getPassword()));
		userService.register(u);
		return "redirect:/";
	}
	 @RequestMapping("/login")
	 public String insertLogic() {
		 return "/user/login";
	 }
	 
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logIn(String username, String password, HttpSession session) {
		UserDTO u = new UserDTO();
		u.setUsername(username);
		u.setPassword(convertSha2(password));
		
		u = userService.auth(u);
		if(u!=null) {
			session.setAttribute("login", u);
			session.setAttribute("nickname", u.getNickname());
			return "redirect:/";
		}
		return "/user/login";
	}
	@GetMapping(value = "/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
}
























