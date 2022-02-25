package com.jl.repository;


import com.jl.bean.Book;
import com.jl.bean.BookVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookVODAO {

	public List<BookVO> findMessage(BookVO bookVO) throws Exception;
	public List<BookVO> findChapter(BookVO bookVO) throws Exception;
	public List<BookVO> findChapterAllNewest(@Param("vo") BookVO vo, @Param("pageSize") Integer pageSize,@Param("pageIndex") Integer pageIndex)throws Exception;
	public List<BookVO> findByKeys(@Param( value = "book")Book book, @Param( value = "count") Integer count);

}
