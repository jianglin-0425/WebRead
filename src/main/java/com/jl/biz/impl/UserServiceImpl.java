package com.jl.biz.impl;

import com.jl.bean.User;
import com.jl.biz.IUserService;
import com.jl.repository.IUserDAO;
import com.jl.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDAO dao;

	@Override
	public int add(User t) throws Exception {
		return dao.add(t);
	}

	@Override
	public User findByTrem(User t) throws Exception {
		List<User> list= dao.findCondition(t,null,null);
		if (list.size()<=0||list.isEmpty()){
			return null;
		}
		return list.get(0);
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

	@Override
	public List<User> findByCondition(User t,String pageIndex,String pageSize) throws Exception {
		return dao.findCondition(t,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	@Override
	public int getEmailCount(User user) {
		return dao.getEmailCount(user);
	}

}
