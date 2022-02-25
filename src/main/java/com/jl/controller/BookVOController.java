package com.jl.controller;

import com.jl.bean.Book;
import com.jl.bean.BookVO;
import com.jl.biz.IBOOKVOService;
import com.jl.biz.IBookService;
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
@RequestMapping("bookVo")
public class BookVOController{

	@Autowired
	IBOOKVOService service;

	@Autowired
	IBookService bookService;


	@RequestMapping("findMessage")
	private JsonModel doFindMessage(HttpServletRequest request, HttpServletResponse response, BookVO info) throws Exception {
		JsonModel jsonModel=new JsonModel();
		List<BookVO> list = service.findMessage(info);

		//返回json 数据
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		jsonModel.setCode(1);
		return jsonModel;
	}

	@RequestMapping("findChapter")
	private JsonModel doFindChapter(HttpServletRequest request, HttpServletResponse response, Book info, BookVO b) throws Exception {
		JsonModel jsonModel=new JsonModel();
		System.out.println(b);
		System.out.println(info);
		List<BookVO> list = service.findChapter(b);
		Map<String,Object> map=new HashMap<>();
		System.out.println(list.size());
		List<BookVO> book=service.findMessage(b);
		map.put("chapter", list);
		map.put("book", book);
		bookService.updateHot(info);
		//返回json 数据
		jsonModel.setObj(map);
		jsonModel.setMsg("succed");
		jsonModel.setCode(1);
		return jsonModel;
	}
}
