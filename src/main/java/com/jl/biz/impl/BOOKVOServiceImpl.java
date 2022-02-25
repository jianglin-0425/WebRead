package com.jl.biz.impl;


import com.jl.bean.Book;
import com.jl.bean.BookVO;
import com.jl.biz.IBOOKVOService;
import com.jl.repository.IBookVODAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BOOKVOServiceImpl implements IBOOKVOService {

	@Autowired
	IBookVODAO bookVODAO;
	@Override
	public List<BookVO> findMessage(BookVO bookVO) throws Exception {
		List<BookVO> list=bookVODAO.findMessage(bookVO);
		for (BookVO info : list) {
			info.setBtype(info.getBtype().substring(0, 2));
		}
		return list;
	}

	@Override
	public List<BookVO> findByKeys(Book book, Integer count) {
		System.out.println(book);
		List<BookVO>  list=bookVODAO.findByKeys(book,count);
		for (BookVO info : list) {
			info.setBtype(info.getBtype().substring(0, 2));
			info.setAuthName(info.getAuthName().split("：")[1]);

			//时间处理  2021-01-03 14:36:48  =====》》》01-03

			String[] times=info.getWtime().split(" ");
			String[] datas=times[0].split("-");
			info.setWtime(datas[1]+"-"+datas[2]);
		}
		return list;
	}

	@Override
	public List<BookVO> findChapter(BookVO bookVO) throws Exception {
		List<BookVO>  list=bookVODAO.findChapter(bookVO);
		for (BookVO info : list) {
			info.setBtype(info.getBtype().substring(0, 2));
		}
		return list;
	}

}
