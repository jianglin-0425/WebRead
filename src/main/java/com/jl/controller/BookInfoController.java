package com.jl.controller;

import com.jl.bean.Book;
import com.jl.bean.BookVO;
import com.jl.biz.IBOOKVOService;
import com.jl.biz.IBookService;
import com.jl.biz.IInformationServer;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class BookServlet
 */

@RestController
@RequestMapping("bookinfo")
public class BookInfoController{

	@Autowired
	IBookService service ;
	@Autowired
	IBOOKVOService bookvoService;
	@Autowired
	IInformationServer iService ;

	@RequestMapping("rank")
	private JsonModel doRank(HttpServletRequest request, HttpServletResponse response , String count) throws Exception {
		JsonModel jsonModel=new JsonModel();
		Map<String, Object> map=new HashMap<>();
		List<String> types=service.getType();
		List<Map<String, Object>> list=new ArrayList<>();
		Book b=new Book();
		List<Book> all=service.findHot(b, 40);
		for (int i = 0; i < types.size(); i++) {
			b.setBtype(types.get(i));
			map.put(""+i,service.findByType(b, count));
			//System.out.println(map);
		}
		Map<String, Object> result=new HashMap<>();
		list.add(map);
		result.put("type", list);
		result.put("all", all);
		jsonModel.setObj(result);
		jsonModel.setCode(1);
		jsonModel.setMsg("succed");
		return jsonModel;
				
	}
	@RequestMapping("findbyType")
	private JsonModel doFindType(HttpServletRequest request, HttpServletResponse response,Book info,BookVO vo) {
		JsonModel jsonModel=new JsonModel();
		String index=request.getParameter("index");
		try {
			List<Book> top=service.findByType(info,"6");
			List<BookVO> left=service.findChapterAllNewest(vo, "30",index );
			List<Book> right=service.findByType(info,"30");
			
			Map<String, Object> map=new HashMap<>();
			map.put("left", left);
			map.put("top", top);
			map.put("right", right);
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

	private JsonModel doIndexFindbyType(HttpServletRequest request, HttpServletResponse response,Book info) {
		JsonModel jsonModel=new JsonModel();
		String count=request.getParameter("count");
		try {
			List<Book> hot=service.findByType(info,count);
			List<Book> right=service.findByType(info,"30");
			Map<String, Object> map=new HashMap<>();
			map.put("hot",hot);
			map.put("right",right);
			map.put("left", null);
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

	@RequestMapping("findIndex")
	private JsonModel doFindIndex(HttpServletRequest request, HttpServletResponse response,Book info) {
		JsonModel jsonModel=new JsonModel();
		try {
			Map<String, Object> results=new HashMap<>();
			Map<String, Object> map=new HashMap<>();
			List<Book> index=service.findAll(null);
			List<String> types=service.getType();
			List<Map<String, Object>> list=new ArrayList<>();
			Book b=new Book();

			for (int i = 0; i < types.size(); i++) {
				b.setBtype(types.get(i));
				map.put(""+i,service.findByType(b, ""+13));

			}
			list.add(map);
			List<Book> right=service.findByType(info,"30");
			List<BookVO> left=service.findChapterAllNewest(null, "30","1" );
			List<Book> hot=service.findHot(b, 6);
			results.put("main", index);
			results.put("types", list);
			results.put("right", right);
			results.put("left", left);
			results.put("hot", hot);

			jsonModel.setCode(1);
			jsonModel.setMsg("succed");
			jsonModel.setObj(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}

	@RequestMapping("findType")
	private JsonModel doFindbyType(HttpServletRequest request, HttpServletResponse response,Book info) {
		JsonModel jsonModel=new JsonModel();

		String count=request.getParameter("count");
		if (count==null){
			count="6";
		}
		try {
			List<Book> hot=service.findByType(info,count);
			List<Book> right=service.findByType(info,"30");
			Map<String, Object> map=new HashMap<>();
			map.put("hot",hot);
			map.put("right",right);
			map.put("left", null);

			jsonModel.setCode(1);
			jsonModel.setMsg("succed");
			jsonModel.setObj(map);

		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
			e.printStackTrace();
		}

		return jsonModel;
	}

	@RequestMapping("findAll")
	private JsonModel doFindAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		List<Book> list = service.findAll(null);
		System.out.println(list);
		//返回json 数据
		jsonModel.setCode(1);
		jsonModel.setMsg("succed");
		jsonModel.setObj(list);
		return jsonModel;
	}

	@RequestMapping("findbyPage")
	private JsonModel finduser(HttpServletRequest request, HttpServletResponse response, Book book) throws Exception {
		JsonModel jsonModel=new JsonModel();
		String pageSize= request.getParameter("pageSize");
		String pageIndex= request.getParameter("pageIndex");
		List<Book> list= service.findByPage(book,pageIndex,pageSize);

		jsonModel.setCode(1);
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
	@RequestMapping("getLength")
	public JsonModel getLength(HttpServletRequest request, HttpServletResponse response, Book book) throws Exception {
		JsonModel jsonModel=new JsonModel();
		int length= service.getLength(book);

		jsonModel.setCode(1);
		jsonModel.setObj(length);
		jsonModel.setMsg("succed");
		return jsonModel;
	}

	@RequestMapping("findByKey")
	public JsonModel findByKey(HttpServletRequest request, HttpServletResponse response, Book book) throws Exception {
		JsonModel jsonModel=new JsonModel();
		List<BookVO> list= bookvoService.findByKeys(book,30);

		jsonModel.setCode(1);
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}



}
