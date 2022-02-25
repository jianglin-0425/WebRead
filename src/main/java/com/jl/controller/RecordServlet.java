package com.jl.controller;


import com.jl.bean.Record;
import com.jl.bean.User;
import com.jl.biz.IRecordService;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("record")
public class RecordServlet {

	@Autowired
	IRecordService service;

	@RequestMapping("deleteRecord")
	private JsonModel doDeleteRecord(HttpServletRequest request, HttpServletResponse response, Record r) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		r.setUserid(user.getUserid());
		int i= service.delete(r);
		jsonModel.setMsg("succed");
		jsonModel.setObj(i);
		jsonModel.setCode(i);
		return jsonModel;
	}
}
