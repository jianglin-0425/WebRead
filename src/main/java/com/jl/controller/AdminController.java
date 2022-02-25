package com.jl.controller;

import com.jl.bean.Admin;
import com.jl.biz.IAdminService;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	IAdminService service;

	@RequestMapping("checkLogin")
	private JsonModel doCheckLogin(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jsonModel=new JsonModel();
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		System.out.println(admin);
		if (admin!=null){
			jsonModel.setObj(admin);
			jsonModel.setCode(1);
			jsonModel.setMsg("succed");
		}else {
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
		}
		return jsonModel;
	}
	@RequestMapping("login")
	private JsonModel doLogin(HttpServletRequest request, HttpServletResponse response,Admin admin ) throws Exception {
		JsonModel jsonModel = new JsonModel();
		Admin loginAdmin = service.login(admin);
		System.out.println(admin);
		if (null == loginAdmin) {
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
		} else {
			request.getSession().setAttribute("admin", loginAdmin);
			jsonModel.setObj(loginAdmin);
			jsonModel.setCode(1);
			jsonModel.setMsg("succed");
		}
		return jsonModel;
	}

	@RequestMapping("findAdmin")
	private JsonModel findAdmin(HttpServletRequest request, HttpServletResponse response,Admin admin ) throws Exception {
		JsonModel jsonModel = new JsonModel();

		List<Admin> list=service.findByTrem(admin);
		System.out.println(list);
		jsonModel.setMsg("succed");
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		return jsonModel;
	}
}
