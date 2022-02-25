package com.jl.bean;

import lombok.Data;

@Data
public class FeedBack {

	private Integer fid;	//反馈编号
	private Integer userid;	//用户id
	private String title;	//标题
	private String content;	//内容
	private String wtime;	//反馈时间
}
