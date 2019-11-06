package com.kh.chat.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.chat.model.dao.ChatDao;
import com.kh.chat.model.vo.Member;

@Service
public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatDao cDao;
		
	@Override
	public Member login(Member m) {
		return cDao.login(m);
	}

	@Override
	public int join(Member m) {
		return cDao.join(m);
	}
	
}
