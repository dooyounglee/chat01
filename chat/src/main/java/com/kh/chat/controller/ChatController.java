package com.kh.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.chat.model.service.ChatService;

@Controller
public class ChatController {

	@Autowired
	private ChatService cService;
	
	@RequestMapping("login.do")
	public String loginUser() {
		return "";
	}
	
	
}
