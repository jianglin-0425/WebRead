package com.jl.bean;

import lombok.Data;

@Data
public class BookCase {

	private Integer bcid;		//书架编号
	private Integer userid;		//用户编号
	private Integer bid;		//书籍编号
	private Integer sno;		//章节编号
	private String rtime;		//添加时间
	
}
