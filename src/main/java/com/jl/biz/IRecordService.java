package com.jl.biz;

import com.jl.bean.BookCaseVO;
import com.jl.bean.Record;
import com.jl.bean.User;

import java.util.List;

public interface IRecordService {
	
	public int add(Record r) throws Exception;
	
	public List<Record> find(Record r) throws Exception;
	
	public int delete(Record r) throws Exception;
	
	public int updateTime(Record r) throws Exception;
	
	public List<BookCaseVO> findRecordVO(User user) throws Exception;

	public int addOrUpdate(Record r);
}
