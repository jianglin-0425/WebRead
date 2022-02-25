package com.jl.repository;

import com.jl.bean.FeedBack;
import com.jl.bean.FeedBackVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFeedBackDAO {
	
	public int add(FeedBack f) ;
	
	public List<FeedBack> find(FeedBack f) ;
	
	public int delete(FeedBack f) ;
	
	public List<FeedBackVO> findVO(FeedBackVO f) ;

	public List<FeedBackVO> findByPage(@Param("feedBack") FeedBack feedBack, @Param("pageSize") Integer pageSize, @Param("pageIndex") Integer pageIndex);
	
}
