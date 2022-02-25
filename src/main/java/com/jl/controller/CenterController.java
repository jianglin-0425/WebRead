package com.jl.controller;

import com.jl.bean.Book;
import com.jl.bean.User;
import com.jl.bean.UserVO;
import com.jl.biz.IBookCaseService;
import com.jl.biz.IUserVOService;
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
@RequestMapping("center")
public class CenterController {

	@Autowired
	IUserVOService service;
	@Autowired
	IBookCaseService bookCaseService;


	private JsonModel doFindMessage(HttpServletRequest request, HttpServletResponse response, UserVO vo, Book b) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		List<Book> loveBook = service.findLoveBook1(b);
		List<UserVO> collection = service.findCollection(vo);
		List<UserVO> find = service.findUserInfo(vo);
		Map<String,Object> map=new HashMap<>();
		map.put("loveBook", loveBook);
		map.put("collection", collection);
		map.put("find", find);
		jsonModel.setObj(map);
		jsonModel.setMsg("succed");
		jsonModel.setCode(1);
		return jsonModel;

	}

	@RequestMapping("findMessage")
	private JsonModel doFindInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		Map<String, Object> map=new HashMap<>();
		int length=bookCaseService.getLength(user);
		map.put("length", length);
		jsonModel.setObj(map);
		jsonModel.setMsg("succed");
		jsonModel.setCode(1);
		return jsonModel;
	}
	

}
