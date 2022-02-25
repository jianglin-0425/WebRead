package com.jl.controller;


import com.jl.bean.FeedBack;
import com.jl.bean.FeedBackVO;
import com.jl.bean.User;
import com.jl.biz.IFeedBackService;
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
@RequestMapping("feedback")
public class FeedBackServlet {
	

	@Autowired
	IFeedBackService service ;

	@RequestMapping("findFeedBackVO")
	private JsonModel doFindFeedBackVO(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		FeedBackVO f=new FeedBackVO();
		User user=(User)request.getSession().getAttribute("loginUser");
		f.setUserid(user.getUserid());
		List<FeedBackVO> list=service.findVO(f);
		List<FeedBack> feedBacks=service.find(user.getUserid());
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("reply", list);
		map.put("feedback", feedBacks);
		jsonModel.setCode(1);
		jsonModel.setObj(map);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
	@RequestMapping("deleteFeedBack")
	private JsonModel doDeleteFeedBack(HttpServletRequest request, HttpServletResponse response,FeedBack f) throws Exception {
		JsonModel jsonModel=new JsonModel();
		int result=service.delete(f);
		jsonModel.setCode(result);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
	@RequestMapping("addFeedBack")
	private JsonModel doAddFeedBack(HttpServletRequest request, HttpServletResponse response,FeedBack f) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		f.setUserid(user.getUserid());
		int result=service.add(f);
		jsonModel.setCode(1);
		jsonModel.setObj(result);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
	@RequestMapping("getFeedBack")
	private JsonModel doGetFeedBack(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		List<FeedBack> list=service.find(user.getUserid());
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}

	@RequestMapping("getFeedBackAdmin")
	private JsonModel getFeedBackAdmin(HttpServletRequest request, HttpServletResponse response,FeedBack feedBack) throws Exception {
		JsonModel jsonModel=new JsonModel();
		User user=(User)request.getSession().getAttribute("loginUser");
		String pageSize= request.getParameter("pageSize");
		String pageIndex= request.getParameter("pageIndex");
		List<FeedBackVO> list=service.findByPage(feedBack,pageSize,pageIndex);
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		jsonModel.setMsg("succed");
		return jsonModel;
	}
}
