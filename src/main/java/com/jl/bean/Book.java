package com.jl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	Integer bid;		//书籍编号
	String bname;		//书籍名
	String authname;	//作者名
	String btype;		//书籍类型
	String intro;		//介绍
	String img;			//书籍照片
	Integer hot;		//点击量
}
