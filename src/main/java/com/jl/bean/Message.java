package com.jl.bean;

import lombok.Data;

@Data
public class Message {
	Integer mid;	//信息编号
	Integer sender;	//发送者编号 adminid
	String title;	//标题
	String message;	//内容
	String sendtime;//发送时间
	Integer reciver;//接受者编号  uid

	
}
