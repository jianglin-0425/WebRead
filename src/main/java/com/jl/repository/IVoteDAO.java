package com.jl.repository;

import com.jl.bean.Vote;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoteDAO {
	
	public int add(Vote vote);
	
	public int update(Vote vote) ;
	
	public List<Vote> find(Vote vote) ;

}
