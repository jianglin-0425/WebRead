package com.jl.biz.impl;


import com.jl.bean.BookCaseVO;
import com.jl.bean.Record;
import com.jl.bean.User;
import com.jl.biz.IRecordService;
import com.jl.repository.IRecordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecordServiceImpl implements IRecordService {

	@Autowired
	IRecordDAO dao;
	
	@Override
	public int add(Record r)   throws Exception {

		return dao.add(r);
	}

	@Override
	public List<Record> find(Record r) throws Exception {
		
		return dao.find(r);
	}

	@Override
	public int delete(Record r) throws Exception {
		return dao.delete(r);
	}

	@Override
	public int updateTime(Record r) throws Exception {
		return dao.updateTime(r);
	}
	@Override
	public List<BookCaseVO> findRecordVO(User user) throws Exception {
		List<BookCaseVO> list=dao.findRecordVO(user);
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
	@Transactional
	public int addOrUpdate(Record r) {
		int result=0;
		if (r.getBid()!=null&&r.getUserid()!=null){
			List<Record> list=null;
			Integer sno=r.getSno();
			r.setSno(null);
			try{
				list=dao.find(r);
				r.setSno(sno);
				System.out.println(list);
				System.out.println(list.size());
				System.out.println(list.size()>0);
				System.out.println(list.isEmpty());
				if (list.size()>0||!list.isEmpty()){
					//TODO:修改时间及章节
					result=dao.updateTime(r);
					System.out.println("update"+result);
				}else {
					//TODO:插入时间及章节
					result=dao.add(r);
					System.out.println("insert"+result);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}


}
