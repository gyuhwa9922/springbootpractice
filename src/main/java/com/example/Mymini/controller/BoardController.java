package com.example.Mymini.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReplyService replyService;

	@RequestMapping(value = "/write/category/{id}", method = RequestMethod.POST)
	public String insert(HttpSession session, @RequestParam("title") String title,
			@RequestParam("content") String content,@PathVariable int id) {

		BoardDTO b = new BoardDTO();
		UserDTO u = (UserDTO) session.getAttribute("login");
		b.setWriterId(u.getId());
		b.setTitle(title);
		b.setContent(content);
		b.setCategoryId(id);
		
		boardService.insert(b);
		return "redirect:/board/category/"+id+"/1";
	}

	@RequestMapping("/write/category/{id}")
	public String insertLogic(@PathVariable int id, Model model) {
		model.addAttribute("id",id);
		return "/board/write";
	}
	 @RequestMapping("/update/{id}")
	 public String updateLogic(@PathVariable int id,Model model) {
		 model.addAttribute("b",boardService.selectOne(id));
		 return "/board/update";
	 }
	 
	@RequestMapping("/selectOne/{id}")
	public String selectOne(@PathVariable int id, HttpSession session, Model model) {
		if (session.getAttribute("login") == null) {
			return "redirect:/";
		}
		BoardDTO b = boardService.selectOne(id);
		if (b == null) {
			return "redirect:/board/showAll";
		}
		model.addAttribute("b", b);
		model.addAttribute("nickname", userService.selectOne(b.getWriterId()).getNickname());
		UserDTO login = (UserDTO) session.getAttribute("login");
		model.addAttribute("logInId", login.getId());
		model.addAttribute("categoryId", b.getCategoryId());
		
		
		List<ReplyDTO> list = replyService.selectAll(id);
		
		HashMap<Integer, String> nicknameMap = new HashMap<>();
		
		for(ReplyDTO r : list) {
			nicknameMap.put(r.getWriterId(), userService.selectOne(r.getWriterId()).getNickname());
		}
		model.addAttribute("r", list);
		model.addAttribute("nicknameMap" ,nicknameMap);
		return "board/showOne";
	}
	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable int id, @RequestParam("Up_title") String Up_title,
			@RequestParam("Up_content") String Up_content) {
		BoardDTO b = new BoardDTO();
		b.setId(id);
		b.setTitle(Up_title);
		b.setContent(Up_content);

		boardService.update(b);
		return "redirect:/board/selectOne/";
	}

	@GetMapping("/category/{id}")
	public String categoryAll(@PathVariable int id) {
		return "redirect:/board/category/" + id + "/1";
	}

	@RequestMapping(value = "/category/{id}/{pageNo}")
	public String categoryAll(@PathVariable int id, @PathVariable int pageNo, HttpSession session, Model model) {
		UserDTO login = (UserDTO) session.getAttribute("login");
		if (login == null) {
			return "redirect:/";
		}
		List<BoardDTO> list = boardService.selectAll(pageNo, id);

		HashMap<Integer, String> nicknameMap = new HashMap<>();

		for (BoardDTO b : list) {
			nicknameMap.put(b.getWriterId(), userService.selectOne(b.getWriterId()).getNickname());
		}
		model.addAttribute("id", id);
		model.addAttribute("list", list);
		model.addAttribute("nicknameMap", nicknameMap);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("lastPageNo", boardService.selectLastPage(id));
		return "/board/category";
	}
}
