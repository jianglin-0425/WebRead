package com.jl.repository;


import com.jl.bean.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdminDAO {

	public int add(Admin admin) throws Exception;
	
	public List<Admin> find(Admin admin) throws Exception;
	
	public int updatePwd(Admin admin) throws Exception;
	
	public Admin findByTrem(Admin admin) throws Exception ;

}
