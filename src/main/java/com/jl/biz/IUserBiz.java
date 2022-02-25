package com.jl.biz;


import com.jl.bean.User;

public interface IUserBiz {

	public int add(User t) throws Exception ;

	public User findByTrem(User t) throws Exception;
	
	public User login(User t)throws Exception;
	
	public int updateInfo(User t)throws Exception;

	int updatePwd(User userInfo) throws Exception;

	
}
