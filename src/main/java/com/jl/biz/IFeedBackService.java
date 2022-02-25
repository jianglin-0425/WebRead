package com.jl.biz;


import com.jl.bean.FeedBack;
import com.jl.bean.FeedBackVO;

import java.util.List;

public interface IFeedBackService {
	
	public int add(FeedBack f) throws Exception;
	
	public List<FeedBack> find(Integer userid) throws Exception;
	
	public int delete(FeedBack f) throws Exception;
	
	public List<FeedBackVO> findVO(FeedBackVO f) throws Exception;

	public List<FeedBackVO> findByPage( FeedBack feedBack, String pageSize, String pageIndex);
}
