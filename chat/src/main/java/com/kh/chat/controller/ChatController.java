package com.kh.chat.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public ModelAndView loginUser(ModelAndView mv,HttpServletRequest req, HttpSession session) {
		
		Cookie[] cookies=req.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("idid")) {
					Member m=new Member();
					m.setId(c.getValue());
					session.setAttribute("mem", cService.getMember(m));
					mv.setViewName("mainPage");
					return mv;
				}
			}
		}
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
		
		int result=cService.join(m);
		if(result>0) {
			mv.setViewName("index");
		}else {
			mv.setViewName("join");
		}
		return mv;
	}
	
	@RequestMapping("login.do")
	public String loginUser(Member m, HttpSession session, String remember, HttpServletResponse res) {
		
		Member mem = cService.login(m);
		if(mem!=null) {
			session.setAttribute("mem", mem);
			if(remember!=null) {
				Cookie cookie=new Cookie("idid", mem.getId());
				cookie.setMaxAge(60*60*24*7);
				cookie.setPath("/");
				res.addCookie(cookie);
			}
			return "mainPage";
		}else {
			return "";
		}
	}
	
	@PostMapping("logout.do")
	public String logout(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		
		session.invalidate();
		Cookie[] cookies=req.getCookies();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("idid")) {
					c.setMaxAge(0);
					c.setPath("/");
					res.addCookie(c);
					break;
				}
			}
		}
		return "redirect:/";
	}
	
	
}
