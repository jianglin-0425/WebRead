package com.jl.controller;

import com.jl.bean.Information;
import com.jl.bean.InformationVO;
import com.jl.biz.IInformationServer;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("info")
public class InformationController {

	@Autowired
	IInformationServer service;

	@RequestMapping("getInfo")
	private JsonModel doGetContent(HttpServletRequest request, HttpServletResponse response, Information info) throws Exception {
		JsonModel jsonModel=new JsonModel();
		String count=request.getParameter("count");
		if (count==null){
			count=6+"";
		}
		List<InformationVO> list=service.findVOByPage(info,count);
		jsonModel.setObj(list);
		jsonModel.setCode(1);
		jsonModel.setMsg("succed");
		return jsonModel;
	}

	@RequestMapping("addinfo")
	private JsonModel get(HttpServletRequest request, HttpServletResponse response, Information info) throws Exception {

		JsonModel jsonModel=new JsonModel();

		//TODO:添加
//		service.add()
		jsonModel.setObj(null);
		jsonModel.setCode(1);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
}
