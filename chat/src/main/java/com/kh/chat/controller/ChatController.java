package com.kh.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.chat.model.service.ChatService;
import com.kh.chat.model.vo.Member;

@Controller
public class ChatController {

	@Autowired
	private ChatService cService;
	
	@RequestMapping("login.do")
	public String loginUser(Member m) {
		
		int result = cService.login(m);
		
		if(result > 0) {
			
		}else {
			
		}
		return "";
	}
	
	
}
