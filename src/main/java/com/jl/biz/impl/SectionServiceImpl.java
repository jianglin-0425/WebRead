package com.jl.biz.impl;

import com.jl.bean.SectionInfo;
import com.jl.biz.ISectionService;
import com.jl.repository.ISectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionServiceImpl implements ISectionService {

	@Autowired
	ISectionDAO dao;
	@Override
	public SectionInfo getContent(SectionInfo info) throws Exception {
		return dao.getContent(info);
	}
	@Override
	public Integer getLength(SectionInfo info) throws Exception {
		
		return (int)dao.getLength(info);
	}

}
