package com.jl.biz.impl;


import com.jl.bean.Book;
import com.jl.bean.BookVO;
import com.jl.biz.IBookService;
import com.jl.repository.IBookDAO;
import com.jl.repository.IBookVODAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {


	@Autowired
	IBookDAO dao ;
	@Autowired
	IBookVODAO voDAO;
	@Override
	public int add(Book b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Book> findAll(Book b) throws Exception {
		List<Book>  list=dao.findByCondition(b,30);
		System.out.println(list.size());
		for (Book info : list) {
			info.setAuthname(info.getAuthname().split("：")[1]);
		}
		return list;
	}


	@Override
	public List<Book> findByType(Book b,String count) throws Exception {
		if (b!=null&&b.getBtype()!=null){
			b.setBtype(b.getBtype().substring(0, 2));
		}
		List<Book>  list=dao.findByCondition(b,Integer.parseInt(count));
		if (Integer.parseInt(count)==13){
			System.out.println(list);
			System.out.println(b);
		}else {
			System.out.println(b);
		}
		for (Book info : list) {
			info.setAuthname(info.getAuthname().split("：")[1]);
			info.setBtype(info.getBtype().substring(0, 2));
		}

		return list;
	}



	@Override
	public List<Book> findNewBook(Book b) throws Exception {
		List<Book>  list=dao.findNewBook(b);
		for (Book info : list) {
			info.setAuthname(info.getAuthname().split("：")[1]);
		}
		return list;
	}


	@Override
	public List<Book> findNewList(Book b) throws Exception {
		List<Book>  list=dao.findNewList(b,4);
		for (Book info : list) {
			info.setAuthname(info.getAuthname().split("：")[1]);
		}
		return list;
	}
	@Override
	public List<String> getType() throws Exception {
		List<String> list=dao.findType();
		return list;
	}


	@Override
	public List<BookVO> findChapterAllNewest(BookVO vo, String pageSize, String pageIndex)throws Exception {
		List<BookVO> list=voDAO.findChapterAllNewest(vo, Integer.parseInt(pageSize),Integer.parseInt(pageIndex));
		for (BookVO v : list) {
			v.setAuthName(v.getAuthName().split("：")[1]);
		
			v.setBtype(v.getBtype().substring(0,2));
		}
		return list;
	}


	@Override
	public Book finSingleBook(Book info) throws Exception {
		Book book=dao.findOne(info);
		if (book!=null) {
			if (book.getBtype()!=null) {
				book.setBtype(book.getBtype().substring(0, 2));	
			}
			
			if (book.getAuthname()!=null) {
				book.setAuthname(book.getAuthname().split("：")[1]);
			}
		}
		return book;
	}


	@Override
	public int updateHot(Book b) throws Exception {
		return dao.updateHot(b);
	}
	@Override
	public List<Book> findHot(Book b,Integer count) throws Exception {
	
		List<Book> list=dao.findHot(b, count);	
		for (Book book : list) {
			book.setAuthname(book.getAuthname().split("：")[1]);
			book.setBtype(book.getBtype().substring(0, 2));
		}
		return list;
	}

	@Override
	public List<Book> findByPage(Book book, String pageIndex, String pageSize) throws Exception {
		List<Book> list=dao.findByPage(book,Integer.parseInt(pageSize),Integer.parseInt(pageIndex));
		for (Book b:list) {
			if (b.getBtype()!=null) {
				String type="";
				String[] types=b.getBtype().split("、");
				for (int i = 0; i < types.length; i++) {
					type+=types[i].substring(0, 2)+" ";
				}
				b.setBtype(type);
			}
		}
		return list;
	}

	@Override
	public int getLength(Book book) throws Exception {
		return dao.getLength(book);
	}

	@Override
	public List<Book> findByKeys(Book book, int count) {
		return dao.findByKeys(book,count);
	}
}
