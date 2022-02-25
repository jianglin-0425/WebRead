package com.jl.repository;


import com.jl.bean.BookCaseVO;
import com.jl.bean.Record;
import com.jl.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecordDAO {
	
	public int add(Record r) throws Exception;
	
	public List<Record> find(Record r) throws Exception;
	
	public int delete(Record r) throws Exception;
	
	public int updateTime(Record r) throws Exception;
	
	public List<BookCaseVO> findRecordVO(User user) throws Exception;
}
