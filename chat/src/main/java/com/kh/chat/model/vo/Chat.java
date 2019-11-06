package com.kh.chat.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chat {
	
	private int cl_no;
	private int m_no;
	private String team;
	private String talk_table;
	
}
