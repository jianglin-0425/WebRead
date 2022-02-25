package com.jl.biz.impl;

import com.jl.bean.BookCase;
import com.jl.bean.BookCaseVO;
import com.jl.bean.User;
import com.jl.biz.IBookCaseService;
import com.jl.repository.IBookCaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCaseServiceImpl implements IBookCaseService {

	@Autowired
	IBookCaseDAO dao;
	
	@Override
	public int add(BookCase bookCase) throws Exception {
		
		return dao.add(bookCase);
	}

	@Override
	public List<BookCase> find(BookCase bookCase) throws Exception {
		// TODO Auto-generated method stub
		return dao.find(bookCase);
	}
	
	@Override
	public List<BookCase> findByBid(BookCase bookCase) throws Exception {
		
		return dao.findByBid(bookCase.getBid(),bookCase.getUserid());
	}
	
	@Override
	public int delete(BookCase bookCase) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(bookCase);
	}

	@Override
	public int updateTime(BookCase bookCase) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateTime(bookCase);
	}

	@Override
	public List<BookCaseVO> findVO(User user) throws Exception {
		List<BookCaseVO> list=dao.findVO(user);
		System.out.println(list);
		if (list!=null&&list.size()>0) {
			for (BookCaseVO vo : list) {
				vo.setAuthName(vo.getAuthName().split("：")[1]);
				vo.setBtype(vo.getBtype().substring(0, 2));
				vo.setWtime(vo.getWtime().split(" ")[0]);
				vo.setRtime(vo.getRtime().split(" ")[0]);
			}
		}
		
		return list;
	}

	@Override
	public int getLength(User user) throws Exception {
		
		return dao.getLength(user);
	}

}
