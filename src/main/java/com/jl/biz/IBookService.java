package com.jl.biz;

import com.jl.bean.Book;
import com.jl.bean.BookVO;

import java.util.List;

public interface IBookService {
	/**
	 * 添加
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public int add(Book b) throws Exception;
	
	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	public List<Book> findAll(Book b) throws Exception;
	/**
	 * 根据类型查询
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public List<Book> findByType(Book b,String count) throws Exception;
	/**
	 * 
	 * 最新入库时间，从大到小查询bid
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public List<Book> findNewBook(Book b) throws Exception;
	/**
	 * 
	 * 最近更新小说列表
	 * @param b
	 * @return
	 * @throws Exception
	 */
	public List<Book> findNewList(Book b) throws Exception;

	public List<String> getType() throws Exception;
	
	public List<BookVO> findChapterAllNewest(BookVO vo, String pageSize, String pageIndex)throws Exception;
	
	/**
	 * s
	 * 根据bid查询单个书籍
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public Book finSingleBook(Book info)throws Exception;


	public int updateHot(Book b) throws Exception ;
	
	public List<Book> findHot(Book b,Integer count) throws Exception ;

	public List<Book> findByPage(Book book,String pageIndex ,String pageSize) throws Exception;

	public int getLength(Book book) throws Exception;

	public List<Book> findByKeys( Book book, int count);

}
