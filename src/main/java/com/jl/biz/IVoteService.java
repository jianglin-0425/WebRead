package com.jl.biz;

import com.jl.bean.Vote;

import java.util.List;

public interface IVoteService {
	
	public int add(Vote vote) throws Exception;
	
	public int update(Vote vote) throws Exception;
	
	public List<Vote> find(Vote vote) throws Exception;
}
