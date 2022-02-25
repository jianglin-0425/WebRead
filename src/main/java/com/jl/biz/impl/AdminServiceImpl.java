package com.jl.biz.impl;

import com.jl.bean.Admin;
import com.jl.biz.IAdminService;
import com.jl.repository.IAdminDAO;
import com.jl.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

	@Resource
	IAdminDAO dao;

	@Override
	public int add(Admin t) throws Exception {
		return 0;
	}

	@Override
	public List<Admin> findByTrem(Admin t) throws Exception {
		List<Admin> list=null;
		try{
			list=dao.find(t);
		}catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin login(Admin admin) throws Exception {
		//用户名或密码为空则直接返回null
		if(!StringUtil.doCheckNotNull(admin.getVName()) || !StringUtil.doCheckNotNull(admin.getVPwd())){
			return null;
		}
		Admin a =dao.findByTrem(admin);
		System.out.println(a);
		return a;
	}
}


