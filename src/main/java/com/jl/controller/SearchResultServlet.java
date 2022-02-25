package com.jl.controller;


import com.jl.bean.Vote;
import com.jl.biz.IVoteService;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Servlet implementation class VoteServlet
 */

@RestController
@RequestMapping("searchRequest")
public class SearchResultServlet {

	@Autowired
	IVoteService service;


	@RequestMapping("search")
	private JsonModel doSearch(HttpServletRequest request, HttpServletResponse response, Vote v) throws Exception {
		JsonModel jsonModel=new JsonModel();
		List<Vote> list=service.find(v);
		int result=0;
 		if(list!=null&&list.size()>0){
			result=service.update(list.get(0));
		}else {
			result=service.add(v);

		}
 		jsonModel.setObj(list);
 		jsonModel.setCode(result);
		jsonModel.setMsg("faild");
 		return jsonModel;
	}

}
