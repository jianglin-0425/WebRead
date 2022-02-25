package com.jl.controller;

import com.jl.bean.BookCase;
import com.jl.bean.BookCaseVO;
import com.jl.bean.User;
import com.jl.biz.IBookCaseService;
import com.jl.biz.IRecordService;
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
@RequestMapping("bookCase")
public class BookCaseServlet{

	@Autowired
	IBookCaseService service;
	@Autowired
	IRecordService recordService;

	@RequestMapping("deleteCase")
	private JsonModel doDeleteCase(HttpServletRequest request, HttpServletResponse response, BookCase bookCase) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		bookCase.setUserid(user.getUserid());

		int i= service.delete(bookCase);
		jsonModel.setCode(i);
		jsonModel.setMsg("success");
		return  jsonModel;
	}
	@RequestMapping("findBookCase")
	private JsonModel doFindBookCase(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		List<BookCaseVO> list = service.findVO(user);
		List<BookCaseVO> vos = recordService.findRecordVO(user);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("bookcase", list);
		map.put("record",vos);
		jsonModel.setCode(1);
		jsonModel.setObj(map);
		jsonModel.setMsg("success");
		return  jsonModel;
	}
	@RequestMapping("add")
	private JsonModel doAdd(HttpServletRequest request, HttpServletResponse response,BookCase bookCase) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		if (user==null){
			jsonModel.setCode(0);
			jsonModel.setMsg("fail");
			return  jsonModel;
		}
		bookCase.setUserid(user.getUserid());
		List<BookCase> list=service.findByBid(bookCase);
		int result=0;
		if (list!=null&&list.size()>0) {
			result=service.updateTime(bookCase);
		}else {
			result=service.add(bookCase);
		}
		jsonModel.setCode(1);
		jsonModel.setObj(result);
		jsonModel.setMsg("success");
		return  jsonModel;
	}

}
