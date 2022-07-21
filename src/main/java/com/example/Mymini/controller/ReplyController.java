package com.example.Mymini.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Mymini.model.BoardDTO;
import com.example.Mymini.model.ReplyDTO;
import com.example.Mymini.model.UserDTO;
import com.example.Mymini.service.BoardService;
import com.example.Mymini.service.ReplyService;
import com.example.Mymini.service.UserService;

@Controller
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = "/selectOne/{boardId}", method = RequestMethod.POST)
	public String insert(HttpSession session, @RequestParam("content") String content, @PathVariable int boardId,
			Model model) {

		UserDTO u = (UserDTO) session.getAttribute("login");

		ReplyDTO r = new ReplyDTO();
		r.setWriterId(u.getId());
		r.setBoardId(boardId);
		r.setContent(content);
		
		replyService.insert(r);
		
		
		return "redirect:/board/selectOne/" + boardId;
	}
	
	
}
