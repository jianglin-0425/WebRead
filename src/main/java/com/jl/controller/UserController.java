package com.jl.controller;

import com.jl.bean.User;
import com.jl.biz.IUserService;
import com.jl.utils.FileUploadUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController{
	
	/**
	 * 
	 */
	@Autowired
	IUserService service;

	@RequestMapping("checkEmail")
	private JsonModel doCheckEmail(HttpServletRequest request, HttpServletResponse response, User user) {
		JsonModel jsonModel=new JsonModel();
		try {
			int i=service.getEmailCount(user);
			if (i<=5) {
				jsonModel.setMsg("可用");
				jsonModel.setCode(1);
			}else {
				jsonModel.setMsg("不可用");
				jsonModel.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonModel);
		return  jsonModel;
	}

	@RequestMapping("updatePwd")
	private JsonModel doUpdatePwd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		String pwd=request.getParameter("upwd");
		User user=(User)request.getSession().getAttribute("loginUser");
		user.setUpwd(pwd);
		int i=service.updatePwd(user);
		jsonModel.setMsg("success");
		jsonModel.setCode(i);
		return jsonModel;
	}

	@RequestMapping("updateInfo")
	private JsonModel doUpdateInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User info= FileUploadUtil.paraseRequest(request, User.class);
		User user=(User)request.getSession().getAttribute("loginUser");
		info.setUserid(user.getUserid());
		System.out.println(info);
		int i=service.updateInfo(info);
		if (i>0) {
			request.getSession().setAttribute("loginUser",info);
			jsonModel.setMsg("success");
			jsonModel.setObj(user);
			jsonModel.setCode(i);
		}else {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
		}
		return jsonModel;
	}

	@RequestMapping("checkName")
	private JsonModel doCheckName(HttpServletRequest request, HttpServletResponse response,User user) {
		JsonModel jsonModel=new JsonModel();

		try {
			User u=service.findByTrem(user);
			System.out.println("u"+u);
			System.out.println(user);
			if (u==null) {
				jsonModel.setMsg("success");
				jsonModel.setCode(1);
			}else {
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}

	@RequestMapping("OutLogin")
	private JsonModel doOutLogin(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jsonModel=new JsonModel();
		request.getSession().removeAttribute("loginUser");
		jsonModel.setCode(1);
		jsonModel.setMsg("success");
		return jsonModel;
	}

	@RequestMapping("checkLogin")
	private JsonModel doCheckLogin(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		if(user!=null){
			jsonModel.setCode(1);
			jsonModel.setObj(user);
			jsonModel.setMsg("success");
		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
		}
		return jsonModel;
	}

	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("register")
	private JsonModel doRegister(HttpServletRequest request, HttpServletResponse response,User user ) throws Exception {
		JsonModel jsonModel=new JsonModel();
		int code=service.add(user);
		jsonModel.setCode(code);
		jsonModel.setMsg("success");
		return jsonModel;
	}
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("login")
	private JsonModel doLogin(HttpServletRequest request, HttpServletResponse response,User user ) throws Exception {
		//从session会话中获取登录的用户界面
		JsonModel jsonModel=new JsonModel();
		User loginuser= service.login(user);
		Map<String, Object> map = new HashMap<String,Object>();
		if (null==loginuser) {
			jsonModel.setCode(0);

			jsonModel.setMsg("faild");
		}else{
			//存储到session中
			request.getSession().setAttribute("loginUser", loginuser);
			map.put("user",loginuser);
			jsonModel.setObj(map);
			jsonModel.setCode(1);
			jsonModel.setMsg("succed");
		}
		return jsonModel;
	}
	/**
	 * 检查用户名
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("check")
	private JsonModel doCheck(HttpServletRequest request, HttpServletResponse response,User user) throws Exception {
		JsonModel jsonModel=new JsonModel();
		int result = service.add(user);
		jsonModel.setCode(0);
		String msg="注册失败";
		if(result>1){
			//注册成功
			msg="注册成功";
			jsonModel.setCode(1);
		}

		jsonModel.setObj(user);
		jsonModel.setMsg(msg);
		return jsonModel;
	}

	@RequestMapping("finduser")
	private JsonModel finduser(HttpServletRequest request, HttpServletResponse response,User user) throws Exception {
		JsonModel jsonModel=new JsonModel();
		String pageSize= request.getParameter("pageSize");
		String pageIndex= request.getParameter("pageIndex");
		List<User> list= service.findByCondition(user,pageIndex,pageSize);
		jsonModel.setCode(1);

		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
}
