package com.jl.bean;

import lombok.Data;

@Data
public class SectionInfo {

		Integer sid;	//章节编号
		Integer sno;	//章节号
		Integer	bid;	//书籍编号
		String sname;	//章节名
		String content;	//章节内容
		String wtime;	//录入时间

}
