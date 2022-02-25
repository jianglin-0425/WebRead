package com.jl.biz.impl;


import com.jl.bean.User;
import com.jl.biz.IUserBiz;
import com.jl.repository.IUserDAO;
import com.jl.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl implements IUserBiz {

	@Autowired
	IUserDAO dao ;
	@Override
	public int add(User t) throws Exception {
		return dao.add(t);
	}

	@Override
	public User findByTrem(User user) throws Exception {
		return dao.findOne(user);
	}

	@Override
	public User login(User user) throws Exception {
		//用户名或密码为空则直接返回null
		if(!StringUtil.doCheckNotNull(user.getUname()) || !StringUtil.doCheckNotNull(user.getUpwd())){
			return null;
		}
		return dao.findOne(user);

	}
	@Override
	public int updateInfo(User user) throws Exception {
		return dao.updateUser(user);
	}
	@Override
	public int updatePwd(User user) throws Exception {
		return dao.updateUser(user);
	}

}
