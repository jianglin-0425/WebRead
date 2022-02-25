package com.jl.biz.impl;


import com.jl.bean.FeedBack;
import com.jl.bean.FeedBackVO;
import com.jl.biz.IFeedBackService;
import com.jl.repository.IFeedBackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements IFeedBackService {

	@Autowired
	IFeedBackDAO dao;
	@Override
	public int add(FeedBack f) throws Exception {
		return dao.add(f);
	}

	@Override
	public List<FeedBack> find(Integer userID) throws Exception {
		FeedBack f=new FeedBack();
		f.setUserid(userID);
		return dao.find(f);
	}

	@Override
	public int delete(FeedBack f) throws Exception {
		return dao.delete(f);
	}

	@Override
	public List<FeedBackVO> findVO(FeedBackVO f) throws Exception {
		List<FeedBackVO> list=dao.findVO(f);
		for (FeedBackVO VO : list) {
			VO.setWtime(VO.getWtime().split(" ")[0]);
			VO.setReplytime(VO.getReplytime().split(" ")[0]);
		}
		return list;
	}

	@Override
	public List<FeedBackVO> findByPage(FeedBack feedBack, String pageSize, String pageIndex) {
		List<FeedBackVO> list=null;
		if (pageIndex==null||pageIndex==null){
			list=dao.findByPage(feedBack,null,null);
		}else{
			list=dao.findByPage(feedBack,Integer.parseInt(pageSize),Integer.parseInt(pageIndex));
		}

		//TODO:时间处理

		return list;
	}

}
