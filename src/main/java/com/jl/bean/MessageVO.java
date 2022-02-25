package com.jl.bean;

import lombok.Data;

@Data
public class MessageVO {
	private Integer mid;
	private Integer sender;
	private String title;
	private String message;
	private String sendtime;
	private Integer reciver;
	public String uname;

}
