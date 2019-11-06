package com.kh.chat.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kh.chat.model.vo.Member;

public class ChatDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member login(Member m) {
		return sqlSession.selectOne("chatMapper.login", m);
	}

}
