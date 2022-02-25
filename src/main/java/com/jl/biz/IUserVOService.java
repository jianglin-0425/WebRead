package com.jl.biz;

import com.jl.bean.Book;
import com.jl.bean.UserVO;

import java.util.List;

public interface IUserVOService {

	public List<UserVO> findUserInfo(UserVO userVO) throws Exception;
	public List<UserVO> findCollection(UserVO userVO) throws Exception;
	public int updateUserInfo(UserVO userVO) throws Exception;

	public List<UserVO> findLoveBook(UserVO userVO) throws Exception; 
	
	public	List<Book> findLoveBook1(Book b) throws Exception;//需要修改
	
	
}
