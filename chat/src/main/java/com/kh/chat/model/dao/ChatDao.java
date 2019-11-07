package com.kh.chat.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.chat.model.vo.Member;

@Repository
public class ChatDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member login(Member m) {
		return sqlSession.selectOne("chatMapper.login", m);
	}

	public int join(Member m) {
		return sqlSession.insert("chatMapper.join", m);
	}

	public Member getMember(Member m) {
		return sqlSession.selectOne("chatMapper.getMember", m);
	}

}
