package com.jl.bean;

import lombok.Data;

@Data
public class FeedBackVO {

	private Integer fid;
	private Integer userid;
	private String uname;
	private Integer vid;
	private String vname;
	private String title;
	private String content;
	private String message;
	private String wtime;
	private String replytime;

	
}
