package com.kh.chat.model.service;

import com.kh.chat.model.vo.Member;

public interface ChatService {
	
	Member login(Member m);

	int join(Member m);
	
	
}
