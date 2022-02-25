package com.jl.repository;


import com.jl.bean.BookCase;
import com.jl.bean.BookCaseVO;
import com.jl.bean.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookCaseDAO {

	public int add(BookCase bookCase);

	public List<BookCase> find(BookCase bookCase);

	public int delete(BookCase bookCase);

	public int updateTime(BookCase bookCase) ;

	public List<BookCase> findByBid(@Param("bid") Integer bid,@Param("uid") Integer uid) ;

	public List<BookCaseVO> findVO(User user) ;

	public int getLength(User user) ;
}
