package com.jl.biz;


import com.jl.bean.BookCase;
import com.jl.bean.BookCaseVO;
import com.jl.bean.User;

import java.util.List;

public interface IBookCaseService {
	public int add(BookCase bookCase) throws Exception;
	
	public List<BookCase> find(BookCase bookCase) throws Exception;
	
	public int delete(BookCase bookCase) throws Exception;
	
	public int updateTime(BookCase bookCase) throws Exception;

	public List<BookCase> findByBid(BookCase bookCase) throws Exception;
	
	public List<BookCaseVO> findVO(User user) throws Exception;
	
	public int getLength(User user) throws Exception ;
}	
