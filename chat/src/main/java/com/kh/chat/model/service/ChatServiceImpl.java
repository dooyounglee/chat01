package com.kh.chat.model.service;

import org.springframework.stereotype.Service;

import com.kh.chat.model.dao.ChatDao;
import com.kh.chat.model.vo.Member;

@Service
public class ChatServiceImpl implements ChatService{

	private ChatDao cDao;
		
	@Override
	public Member login(Member m) {
		return cDao.login(m);
	}
	
}
