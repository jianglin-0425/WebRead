package com.jl.repository;


import com.jl.bean.Book;
import com.jl.bean.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserVODAO {

	public List<UserVO> findUserVO(UserVO userVO) ;
	
	public List<UserVO> findCollection(UserVO userVO) ;


	
	public int updateUserInfo(UserVO userVO) ;

	//TODO:
	public List<UserVO> findLoveBook(UserVO userVO) ;

	public List<Book> findLoveBook1(Book b) ;//需要修改
}
