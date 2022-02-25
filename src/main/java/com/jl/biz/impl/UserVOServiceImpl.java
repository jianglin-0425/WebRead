package com.jl.biz.impl;

import com.jl.bean.Book;
import com.jl.bean.UserVO;
import com.jl.biz.IUserVOService;
import com.jl.repository.IUserVODAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVOServiceImpl implements IUserVOService {

	@Autowired
	IUserVODAO dao ;
	
	@Override
	public List<UserVO> findUserInfo(UserVO userVO) throws Exception {
		
		return	dao.findUserVO(userVO);
	}

	@Override
	public List<UserVO> findCollection(UserVO userVO) throws Exception {
		List<UserVO> list=dao.findCollection(userVO);
		for (UserVO info : list) {
			info.setBtype(info.getBtype().substring(0, 2));
		}
		return list;
	}

	@Override
	public List<UserVO> findLoveBook(UserVO userVO) throws Exception {
		
		return null;
	}

	@Override
	public int updateUserInfo(UserVO userVO) throws Exception {
		return dao.updateUserInfo(userVO);
	}

	@Override
	public List<Book> findLoveBook1(Book b) throws Exception {
		return dao.findLoveBook1(b);
	}


}
