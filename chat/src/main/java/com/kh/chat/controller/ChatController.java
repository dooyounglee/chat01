package com.kh.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.chat.model.service.ChatService;
import com.kh.chat.model.vo.Member;

@Controller
public class ChatController {

	@Autowired
	private ChatService cService;
	
	@RequestMapping("/")
	public ModelAndView loginUser(Member m,ModelAndView mv) {
		
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/join.do")
	public ModelAndView join(ModelAndView mv) {
		
		mv.setViewName("join");
		return mv;
	}
	
	@PostMapping("/join.do")
	public ModelAndView joinPost(Member m,ModelAndView mv) {
		
		System.out.println(m);
		int result=cService.join(m);
		if(result>0) {
			mv.setViewName("index");
		}else {
			mv.setViewName("join");
		}
		return mv;
	}
	
	@RequestMapping("login.do")
	public String loginUser(Member m) {
		
		Member mem = cService.login(m);
		System.out.println(mem);
		if(mem!=null) {
			return "mainPage";
		}else {
			return "";
			
		}
	}
	
	
}
