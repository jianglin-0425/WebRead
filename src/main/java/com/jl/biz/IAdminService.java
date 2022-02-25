package com.jl.biz;

import com.jl.bean.Admin;

import java.util.List;

public interface IAdminService {
	
	public int add(Admin t) throws Exception ;

	public List<Admin> findByTrem(Admin t) throws Exception;
	
	public Admin login(Admin t)throws Exception;
}
