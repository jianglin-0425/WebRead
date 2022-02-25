package com.jl.biz;

import com.jl.bean.Book;
import com.jl.bean.BookVO;

import java.util.List;

public interface IBOOKVOService {

	public List<BookVO> findMessage(BookVO bookVO) throws Exception;

	public List<BookVO> findByKeys(Book book,  Integer count);

	public List<BookVO> findChapter(BookVO bookVO) throws Exception;
}
