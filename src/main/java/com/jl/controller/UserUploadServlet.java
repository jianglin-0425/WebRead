package com.jl.controller;


import com.jl.bean.User;
import com.jl.biz.IUserService;
import com.jl.utils.FileUploadUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserUploadServlet {

	/**
	 *
	 */
	@Autowired
	IUserService service;

	@RequestMapping("userFileUpload")
	protected JsonModel upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonModel jsonModel=new JsonModel();
		try {
			User bean= FileUploadUtil.paraseRequest(request, User.class);
			User user=(User)request.getSession().getAttribute("loginUser");
			bean.setUserid(user.getUserid());
			System.out.println("bean="+bean);
			int i=service.updateInfo(bean);
			System.out.println("i="+i);
			jsonModel.setMsg("succed");
			jsonModel.setCode(i);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jsonModel;
	}

}

