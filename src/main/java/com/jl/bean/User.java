package com.jl.bean;

import lombok.Data;

/**
 * 用户实体类  tb_user-->User
 * @author Lenovo
 * 字段名和数据库表中字段名一致
 *
 */
@Data
public class User {

	Integer userid;	//用户编号
	String uname;	//用户名
	String upwd;	//密码
	String email;	//邮箱
	String sex;		//性别
	String ftype;	//喜欢的类型
	String img;		//照片
	String uintro;	//介绍
}
