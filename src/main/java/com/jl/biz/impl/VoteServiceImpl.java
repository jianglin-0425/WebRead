package com.jl.biz.impl;

import com.jl.bean.Vote;
import com.jl.biz.IVoteService;
import com.jl.repository.IVoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteServiceImpl  implements IVoteService {

	@Autowired
	IVoteDAO dao;
	
	@Override
	public int add(Vote vote) throws Exception {
		return dao.add(vote);
	}

	@Override
	public int update(Vote vote) throws Exception {
		return dao.update(vote);
	}

	@Override
	public List<Vote> find(Vote vote) throws Exception {
		return dao.find(vote);
	}

	
}
