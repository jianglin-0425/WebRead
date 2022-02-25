package com.jl.biz;


import com.jl.bean.User;

import java.util.List;

public interface IUserService {

	public int add(User t) throws Exception ;

	public User findByTrem(User t) throws Exception;
	
	public User login(User t)throws Exception;
	
	public int updateInfo(User t)throws Exception;

	int updatePwd(User userInfo) throws Exception;

	public List<User> findByCondition(User t,String pageIndex,String pageSize) throws Exception;

	public int getEmailCount(User user);
}
