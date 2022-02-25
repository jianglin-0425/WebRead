package com.jl.controller;

import com.jl.bean.*;
import com.jl.biz.IBookCaseService;
import com.jl.biz.IBookService;
import com.jl.biz.IRecordService;
import com.jl.biz.ISectionService;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("section")
public class SectionServet {

	@Autowired
	ISectionService service;
	@Autowired
	IBookService bService;
	@Autowired
	IRecordService rService;

	@Autowired
	IBookCaseService bookCaseService;

	@RequestMapping("findContent")
	private JsonModel doFindContent(HttpServletRequest request, HttpServletResponse response, SectionInfo info) {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		try {
			SectionInfo obj = service.getContent(info);
			Book bookInfo= new Book();
			bookInfo.setBid(obj.getBid());
			Integer length=service.getLength(info);
			Map<String, Object> map=new HashMap<String, Object>();
			Book book = bService.finSingleBook(bookInfo);

			if (user!=null) {
				//插入阅读记录
				Record record = new Record();
				record.setBid(book.getBid());
				record.setUserid(user.getUserid());
				record.setSno(obj.getSno());
				System.out.println(record);
				int i=rService.addOrUpdate(record);
				System.out.println(i);

				//修改书架信息
				BookCase bookCase=new BookCase();
				bookCase.setUserid(user.getUserid());
				bookCase.setBid(book.getBid());
				bookCase.setSno(obj.getSno());
				int result=bookCaseService.updateTime(bookCase);
				System.out.println(result);
			}



			map.put("length", length);
			map.put("content", obj);
			map.put("book", book);

			jsonModel.setObj(map);
			jsonModel.setCode(1);
			jsonModel.setMsg("succed");


		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
			e.printStackTrace();
		}
		return jsonModel;
	}


	@RequestMapping("insertRecord")
	private JsonModel insertRecord(HttpServletRequest request, Integer sno, Integer bid) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		System.out.println(user);
		int result=0;
		if (user!=null) {
			Record record=new Record();
			record.setBid(bid);
			record.setUserid(user.getUserid());
			record.setSno(sno);
			result=rService.addOrUpdate(record);
			System.out.println(result);
			System.out.println(record);
			jsonModel.setCode(result);
			jsonModel.setMsg("succed");

		}else{
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");

		}
		return jsonModel;
	}
	
}






















