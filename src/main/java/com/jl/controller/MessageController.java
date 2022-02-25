package com.jl.controller;

import com.jl.bean.Admin;
import com.jl.bean.MessageVO;
import com.jl.biz.IMessageService;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	IMessageService service;

	@RequestMapping("getContent")
	private JsonModel doGetContent(HttpServletRequest request, HttpServletResponse response,MessageVO vo) throws Exception {
		JsonModel jsonModel=new JsonModel();
		MessageVO m=service.findContent(vo);
		jsonModel.setCode(1);
		jsonModel.setObj(m);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
	@RequestMapping("getUserMessage")
	private JsonModel doGetMessage(HttpServletRequest request, HttpServletResponse response, MessageVO m) throws Exception {
		JsonModel jsonModel=new JsonModel();
		List<MessageVO> list=service.findMessage(m);
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
	@RequestMapping("getAdminMessage")
	private JsonModel getAdminMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		List<MessageVO> list=service.findMessage(null);
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
}
